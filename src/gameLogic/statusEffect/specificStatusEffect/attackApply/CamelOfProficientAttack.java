package gameLogic.statusEffect.specificStatusEffect.attackApply;

import gameLogic.statusEffect.AttackApplyStatusEffect;
import gameLogic.statusEffect.StatusEffectBase;

/**
 * @author Napat
 * camel of proficient attack side buff +5 damage per stack to all attack card
 */
public class CamelOfProficientAttack extends StatusEffectBase implements AttackApplyStatusEffect{
	private final int attackBonus = 5;
	public CamelOfProficientAttack() {
		super(statusType,"Camel of Proficient Attack");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAttackBonus(int CurrentAttackDamage) {
		// TODO Auto-generated method stub
		return this.attackBonus*this.getStack();
	}

	@Override
	public void endTurnChange() {
		// TODO Auto-generated method stub
		//this.setStack(this.getStack()-1);
	}

}
