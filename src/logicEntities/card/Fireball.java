package logicEntities.card;

import gameLogic.CardManager;
import gameLogic.GameLogic;
import gameLogic.action.AttackAction;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logicEntities.Player;
import logicEntities.base.Card;
import logicEntities.base.Monster;
import logicEntities.base.cardType.hasTarget;

public class Fireball extends Card implements hasTarget{
	private Monster target;
	private final int attack_power = 5;
	public Fireball() {
		super(4, "Fireball", "Just a normal fireball");
		this.card_ob = new ImageView();
		this.card_ob.setImage(new Image(ClassLoader.getSystemResource("secondScene/images/fireball_blank.png").toString()));
		this.card_ob.setFitHeight(cardHeight);
		this.card_ob.setFitWidth(cardWidth);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void use() {
		if(Player.getInstance().getMana()>=this.manacost) {
			GameLogic.getActionManager().add( new AttackAction("Single",target.getMonster_id(),attack_power) );
			CardManager.disCard(this);
			Player.getInstance().setMana(Player.getInstance().getMana()-this.manacost);
			Player.getInstance().updateMana();
		}
		
	}
	@Override
	public void setTarget(Monster monster) {
		this.target = monster;
		// TODO Auto-generated method stub
	}
}
