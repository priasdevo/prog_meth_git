package gameLogic.statusEffect;

import logicEntities.base.Card;

public abstract class CardUseApplyStatusEffect extends StatusEffectBase{

	public CardUseApplyStatusEffect(String name) {
		super(3, name);
		// TODO Auto-generated constructor stub
	}
	public abstract void Activate(Card cardUsed);
}
