package gameLogic.statusEffect.specificStatusEffect.attackApply;

import gameLogic.statusEffect.AttackApplyStatusEffect;
import gameLogic.statusEffect.StatusEffectBase;

/**
 * @author Napat
 * Bull of power buff + 20 damage for next attack
 */
public class BullOfPower extends StatusEffectBase implements AttackApplyStatusEffect{
	private final int attackBonus = 20;
	public BullOfPower() {
		super(statusType,"Bull of Power");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAttackBonus(int CurrentAttackDamage) {
		// TODO Auto-generated method stub
		this.setStack(this.getStack()-1);
		return this.attackBonus;
	}

	@Override
	public void endTurnChange() {
		// TODO Auto-generated method stub
		//this.setStack(this.getStack()-1);
	}

}
