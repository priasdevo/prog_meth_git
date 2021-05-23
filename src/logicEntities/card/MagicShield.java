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
 * Magic shield card
 */
public class MagicShield extends Card{
	private final int shieldGive = 5;
	public MagicShield() {
		super(1, "Magic Shield", "Grant 5 shield");
		this.card_ob.setImage(CardImageHolder.magic_shield);
	}
	@Override
	public void use() {
		if(Player.getInstance().getMana()>=this.manacost) {
			GameLogic.getActionManager().add(new AddBuffAction("Single","Player",BuffCodeHolder.Shield,this.shieldGive));
			GameLogic.getActionManager().add(new CardUseAction("None",this));
			CardManager.disCard(this);
			Player.getInstance().setMana(Player.getInstance().getMana()-this.manacost);
			Player.getInstance().updateMana();
		}
		
	}
}