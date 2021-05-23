package logicEntities.card;

import gameLogic.CardManager;
import gameLogic.GameLogic;
import gameLogic.action.AllAttackAction;
import gameLogic.action.AttackAction;
import gameLogic.action.CardUseAction;
import logicEntities.Player;
import logicEntities.base.Card;
import logicEntities.base.Monster;
import logicEntities.base.cardType.hasTarget;
import shareObject.CardImageHolder;

/**
 * @author Napat
 * White stallion of sun card
 */
public class WhiteStallionOfSun extends Card{
	private Monster target;
	private final int attack_power = 15;
	public WhiteStallionOfSun() {
		super(2, "White stallion", "Deal 15 damage\n to all enemy");
		this.card_ob.setImage(CardImageHolder.white_stallion_of_sun);
	}
	@Override
	public void use() {
		if(Player.getInstance().getMana()>=this.manacost) {
			GameLogic.getActionManager().add(new CardUseAction("None",this));
			GameLogic.getActionManager().add( new AllAttackAction("All",attack_power) );
			CardManager.disCard(this);
			Player.getInstance().setMana(Player.getInstance().getMana()-this.manacost);
			Player.getInstance().updateMana();
		}
		
	}

}