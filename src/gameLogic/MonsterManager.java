package gameLogic;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import gameLogic.action.AttackAction;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import logicEntities.base.Monster;
import gameLogic.ActionManager;
/**
 * @author Napat
 * Class to manage all monster
 */
public class MonsterManager {
	private ArrayList<Monster> monsterList;

	public MonsterManager() {
		super();
		this.monsterList = new ArrayList<Monster>();
	}
	/**
	 * add Monster to list
	 * @param monster monster to add
	 */
	public void add(Monster monster) {
		this.monsterList.add(monster);
	}
	/**
	 * Clear all monster
	 */
	public void clear() {
		this.monsterList.clear();
	}
	/**
	 * Render monster in List
	 */
	public void renderMonster() {
		for(Monster monster : monsterList) {
			GameLogic.getGrid().add(monster.getMonster_box(),monster.getMonster_xpos(),monster.getMonster_ypos());
			monster.getMonster_ob().setOnDragDropped(new EventHandler<DragEvent>() {
				@Override
				public void handle(DragEvent arg0) {
					GameLogic.addAction(monster);
					GameLogic.getMonsterManager().printMonsterList();
					arg0.consume();
					}
			});
		}
	}
	/**
	 * Clear monster with hp lower than 0
	 * @throws ConcurrentModificationException
	 */
	public void clearMonster() throws ConcurrentModificationException{
		for(Monster monster : monsterList) {
			if(monster.getHp()<=0) {
				//System.out.println("You dieee");
				/*VBox testmonbox = monster.getMonster_box();*/
				FadeTransition ft = new FadeTransition(Duration.millis(200),monster.getMonster_box());
			     ft.setFromValue(1.0);
			     ft.setToValue(0.1);
			     ft.setOnFinished(e -> clearspecificmonster(monster));
			     ft.play();
			     Platform.runLater(()->{
			    	 monsterList.remove(monster);
			     });
			     //renderMonster();
				//testmonbox.setOpacity(0.6);
			}
		}
	}
	/**
	 * delete specific monster
	 * @param monster
	 */
	private void clearspecificmonster(Monster monster) {
		//System.out.println(monster.getMonster_box().getOpacity()+"Opac");
		GameLogic.getGrid().getChildren().remove(monster.getMonster_box());
		monsterList.remove(monster);
	}
	/**
	 * Print the monsterList with hp
	 */
	public void printMonsterList() {
		for(Monster monster : monsterList) {
			System.out.printf("%s  Hp : %d\n", monster.getMonster_id(),monster.getHp());
		}
	}
	/**
	 * Run the action of all monster at Their turn
	 */
	public void monsterAction() {
		//System.out.println("Monster monster!!!");
		for(Monster monster : monsterList) {
			monster.action();
			GameLogic.getActionManager().runAction();
		}
	}
	public ArrayList<Monster> getMonsterList() {
		return monsterList;
	}

	public void setMonsterList(ArrayList<Monster> monsterList) {
		this.monsterList = monsterList;
	}
	
	
}
