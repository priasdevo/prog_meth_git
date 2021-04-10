package gameLogic;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import gameLogic.action.AttackAction;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.GridPane;
import logicEntities.base.Monster;
public class MonsterManager {
	private ArrayList<Monster> monsterList;

	public MonsterManager() {
		super();
		this.monsterList = new ArrayList<Monster>();
	}
	public void add(Monster monster) {
		this.monsterList.add(monster);
	}
	public void clear() {
		this.monsterList.clear();
	}
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
	public void clearMonster() throws ConcurrentModificationException{
		for(Monster monster : monsterList) {
			if(monster.getHp()<=0) {
				GameLogic.getGrid().getChildren().remove(monster.getMonster_box());
				monsterList.remove(monster);
			}
		}
	}
	public void printMonsterList() {
		for(Monster monster : monsterList) {
			System.out.printf("%s  Hp : %d\n", monster.getMonster_id(),monster.getHp());
		}
	}
	public static void attackTurn() {
		
	}
	public ArrayList<Monster> getMonsterList() {
		return monsterList;
	}

	public void setMonsterList(ArrayList<Monster> monsterList) {
		this.monsterList = monsterList;
	}
	
	
}
