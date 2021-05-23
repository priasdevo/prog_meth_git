package gameLogic.statusEffect;

import logicEntities.base.Card;

/**
 * @author Napat
 * The statusEffect that activate when cardUse action is being handle
 */
public interface CardUseApplyStatusEffect{
	static final int statusType = 3;
	public abstract void Activate(Card cardUsed);
}
