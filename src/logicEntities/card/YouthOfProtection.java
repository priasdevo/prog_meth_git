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
 * Youth of protection card
 */
public class YouthOfProtection extends Card{
	private final int shieldGive = 50;
	public YouthOfProtection() {
		super(2, "Youth of Protection", "Grant 50 shield");
		this.card_ob.setImage(CardImageHolder.youth_of_protection);
	}
	@Override
	public void use() {
		if(Player.getInstance().getMana()>=this.manacost) {
			
			GameLogic.getActionManager().add(new CardUseAction("None",this));
			GameLogic.getActionManager().add(new AddBuffAction("Single","Player",BuffCodeHolder.Shield,this.shieldGive));
			CardManager.disCard(this);
			Player.getInstance().setMana(Player.getInstance().getMana()-this.manacost);
			Player.getInstance().updateMana();
		}
		
	}
}