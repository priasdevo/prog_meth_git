package gameLogic.statusEffect.specificStatusEffect.attackApply;

import gameLogic.statusEffect.AttackApplyStatusEffect;

public class BullOfPower extends AttackApplyStatusEffect{

	public BullOfPower() {
		super("BullOfPower");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAttackBonus(int CurrentAttackDamage) {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public void endTurnChange() {
		// TODO Auto-generated method stub
		this.setStack(this.getStack()-1);
	}

}
