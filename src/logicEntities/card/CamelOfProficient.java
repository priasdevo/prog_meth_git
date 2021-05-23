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
 * Camel of proficient card
 */
public class CamelOfProficient extends Card{
	public CamelOfProficient() {
		super(2, "Camel of Proficient", "All your defense and attack card \nincrease it power by 5");
		this.card_ob.setImage(CardImageHolder.camel_of_proficient);
	}
	@Override
	public void use() {
		if(Player.getInstance().getMana()>=this.manacost) {
			GameLogic.getActionManager().add(new CardUseAction("None",this));
			GameLogic.getActionManager().add(new AddBuffAction("Single","Player",BuffCodeHolder.Camel_of_Proficient_Attack,1));
			GameLogic.getActionManager().add(new AddBuffAction("Single","Player",BuffCodeHolder.Camel_of_Proficient_Defense,1));
			CardManager.disCard(this);
			Player.getInstance().setMana(Player.getInstance().getMana()-this.manacost);
			Player.getInstance().updateMana();
		}
		
	}
}
