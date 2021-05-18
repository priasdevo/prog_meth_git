package gameLogic.statusEffect.specificStatusEffect.cardUseApplay;

import gameLogic.statusEffect.CardUseApplyStatusEffect;
import logicEntities.base.Card;

public class WindOfRaptor extends CardUseApplyStatusEffect{

	public WindOfRaptor() {
		super("WindOfRaptor");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Activate(Card cardUsed) {
		// TODO Auto-generated method stub
		cardUsed.use();
		this.setStack(this.getStack()-1);
	}

	@Override
	public void endTurnChange() {
		// TODO Auto-generated method stub
	}

}
