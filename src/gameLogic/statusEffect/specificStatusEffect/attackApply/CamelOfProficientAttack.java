package gameLogic.statusEffect.specificStatusEffect.attackApply;

import gameLogic.statusEffect.AttackApplyStatusEffect;

public class CamelOfProficientAttack extends AttackApplyStatusEffect{

	public CamelOfProficientAttack() {
		super("CamelOfProficientAttack");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAttackBonus(int CurrentAttackDamage) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public void endTurnChange() {
		// TODO Auto-generated method stub
		this.setStack(this.getStack()-1);
	}

}
