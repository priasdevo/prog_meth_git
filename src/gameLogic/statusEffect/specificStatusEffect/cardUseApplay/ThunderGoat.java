package gameLogic.statusEffect.specificStatusEffect.cardUseApplay;

import gameLogic.statusEffect.CardUseApplyStatusEffect;
import gameLogic.statusEffect.StatusEffectBase;
import logicEntities.base.Card;
import logicEntities.base.Monster;
import gameLogic.ActionHandler;
import gameLogic.GameLogic;
import gameLogic.action.AllAttackAction;
import gameLogic.action.AttackAction;

/**
 * @author Napat
 * Deal 3 damage to all enemy when card is used
 */
public class ThunderGoat extends StatusEffectBase implements CardUseApplyStatusEffect{
	private final int damageDeal = 3;
	public ThunderGoat() {
		super(statusType,"Thunder Goat");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Activate(Card cardUsed) {
		// TODO Auto-generated method stub
		for(Monster mon:GameLogic.getMonsterManager().getMonsterList()) {
			ActionHandler.dealDamage(this.damageDeal*this.getStack(), mon.getMonster_id());
		}
		
	}

	@Override
	public void endTurnChange() {
		// TODO Auto-generated method stub
		
	}

}
