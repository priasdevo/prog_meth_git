package gameLogic.statusEffect.specificStatusEffect.defenseApply;

import gameLogic.statusEffect.DefenseApplyStatusEffect;

public class CamelOfProficientDefense extends DefenseApplyStatusEffect{

	public CamelOfProficientDefense() {
		super("DefenseApplySpecialEffect");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getDefenseBonus(int CurrentDefense) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public void endTurnChange() {
		// TODO Auto-generated method stub
		this.setStack(this.getStack()-1);
	}

}
