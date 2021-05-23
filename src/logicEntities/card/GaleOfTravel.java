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
 * Gale of travel card
 */
public class GaleOfTravel extends Card{
	public GaleOfTravel() {
		super(2, "Gale of Travel", "Immune to all \ndamage for 1 turn");
		this.card_ob.setImage(CardImageHolder.gale_of_travel);
	}
	@Override
	public void use() {
		if(Player.getInstance().getMana()>=this.manacost) {
			GameLogic.getActionManager().add(new CardUseAction("None",this));
			GameLogic.getActionManager().add(new AddBuffAction("Single","Player",BuffCodeHolder.Gale_of_Travel,1));
			CardManager.disCard(this);
			Player.getInstance().setMana(Player.getInstance().getMana()-this.manacost);
			Player.getInstance().updateMana();
		}
		
	}
}
