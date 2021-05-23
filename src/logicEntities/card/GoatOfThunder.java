package logicEntities.card;

import gameLogic.CardManager;
import gameLogic.GameLogic;
import gameLogic.action.AddBuffAction;
import gameLogic.action.CardUseAction;
import logicEntities.Player;
import logicEntities.base.Card;
import shareObject.BuffCodeHolder;
import shareObject.CardImageHolder;

/**
 * @author Napat
 * Goat of thunder card
 */
public class GoatOfThunder extends Card{
	public GoatOfThunder() {
		super(2, "Goat of Thunder", "all your card will cause \nthe thunder to comedown \ndeal 3 damage to all enemy");
		this.card_ob.setImage(CardImageHolder.goat_of_thunder);
	}
	@Override
	public void use() {
		if(Player.getInstance().getMana()>=this.manacost) {
			
			GameLogic.getActionManager().add(new CardUseAction("None",this));
			GameLogic.getActionManager().add(new AddBuffAction("Single","Player",BuffCodeHolder.ThunderGoat,1));
			CardManager.disCard(this);
			Player.getInstance().setMana(Player.getInstance().getMana()-this.manacost);
			Player.getInstance().updateMana();
		}
		
	}
}
