package gameLogic.statusEffect.specificStatusEffect.attackApply;

import gameLogic.statusEffect.AttackApplyStatusEffect;

public class MagicAggregation extends AttackApplyStatusEffect{

	public MagicAggregation() {
		super("MagicAggregation");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAttackBonus(int CurrentAttackDamage) {
		// TODO Auto-generated method stub
		return this.getStack();
	}

	@Override
	public void endTurnChange() {
		// TODO Auto-generated method stub
		this.setStack(this.getStack()-1);
	}

}
