package logicEntities.card;

import gameLogic.CardManager;
import gameLogic.GameLogic;
import gameLogic.action.AddBuffAction;
import gameLogic.action.CardUseAction;
import gameLogic.action.HealAction;
import logicEntities.Player;
import logicEntities.base.Card;
import shareObject.BuffCodeHolder;
import shareObject.CardImageHolder;

/**
 * @author Napat
 * Ram who defy death card
 */
public class RamWhoDefyDeath extends Card{
	public RamWhoDefyDeath() {
		super(2, "Ram defy Death", "Heal you to\n full health");
		this.card_ob.setImage(CardImageHolder.ram_who_defy_death);
	}
	@Override
	public void use() {
		if(Player.getInstance().getMana()>=this.manacost) {
			GameLogic.getActionManager().add(new HealAction("Single","Player",Player.getInstance().getHp_max()-Player.getInstance().getHp()));
			GameLogic.getActionManager().add(new CardUseAction("None",this));
			CardManager.disCard(this);
			Player.getInstance().setMana(Player.getInstance().getMana()-this.manacost);
			Player.getInstance().updateMana();
		}
		
	}
}