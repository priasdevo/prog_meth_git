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
 * Raptor of wind card
 */
public class RaptorOfWind extends Card{
	private final int stackGive=1;
	public RaptorOfWind() {
		super(2, "Raptor of Wind", "Your next card\n is play twice");
		this.card_ob.setImage(CardImageHolder.raptor_of_wind);
	}
	@Override
	public void use() {
		if(Player.getInstance().getMana()>=this.manacost) {
			
			GameLogic.getActionManager().add(new CardUseAction("None",this));
			GameLogic.getActionManager().add(new AddBuffAction("Single","Player",BuffCodeHolder.WindOfRaptor,this.stackGive));
			CardManager.disCard(this);
			Player.getInstance().setMana(Player.getInstance().getMana()-this.manacost);
			Player.getInstance().updateMana();
		}
		
	}
}