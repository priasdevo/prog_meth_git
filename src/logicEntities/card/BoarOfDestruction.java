package logicEntities.card;

import gameLogic.CardManager;
import gameLogic.GameLogic;
import gameLogic.action.AttackAction;
import gameLogic.action.CardUseAction;
import javafx.scene.image.Image;
import logicEntities.Player;
import logicEntities.base.Card;
import logicEntities.base.Monster;
import logicEntities.base.cardType.hasTarget;
import shareObject.CardImageHolder;

/**
 * @author Napat
 * Boar of destruction card
 */
public class BoarOfDestruction extends Card implements hasTarget{
	private Monster target;
	private final int attack_power = 30;
	public BoarOfDestruction() {
		super(2, "Boar of destruction", "Deal 30 Damage to target enemy");
		this.card_ob.setImage(CardImageHolder.boar_of_destruction);
	}
	@Override
	public void use() {
		if(Player.getInstance().getMana()>=this.manacost) {
			GameLogic.getActionManager().add( new AttackAction("Single",target.getMonster_id(),attack_power) );
			GameLogic.getActionManager().add(new CardUseAction("None",this));
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
