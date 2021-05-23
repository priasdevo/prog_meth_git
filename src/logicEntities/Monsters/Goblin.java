package logicEntities.Monsters;

import gameLogic.GameLogic;
import gameLogic.action.AttackAction;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import logicEntities.base.Monster;

/**
 * @author Napat
 * Goblin monster
 */
public class Goblin extends Monster{
	private static final int monster_hp = 30;
	private static final int attackDamage = 10;
	public Goblin(String monster_id, int posx,int posy) {
		super("Goblin", monster_id, monster_hp);
		this.monster_height = 150 ;
		this.monster_width = 100 ;
		this.monster_xpos=posx;
		this.monster_ypos=posy;
		this.moster_image = new Image(ClassLoader.getSystemResource("monsterImage/Goblin.png").toString());
		// TODO Auto-generated constructor stub
		this.monster_ob.setFitHeight(monster_height);
		this.monster_ob.setFitWidth(monster_width);
		this.monster_ob.setImage(moster_image);
		this.updateHp();
		this.monster_box.setAlignment(Pos.CENTER);
		this.monster_box.getChildren().addAll(this.monster_ob,this.monster_hp_bar);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		GameLogic.getActionManager().add(new AttackAction("Single","Player",attackDamage));
		// TODO Auto-generated method stub
		
	}

}
