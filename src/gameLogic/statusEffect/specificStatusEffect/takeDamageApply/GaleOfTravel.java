package gameLogic.statusEffect.specificStatusEffect.takeDamageApply;

import gameLogic.statusEffect.TakeDamageApplyStatuslEffect;

public class GaleOfTravel extends TakeDamageApplyStatuslEffect{

	public GaleOfTravel() {
		super("GaleOfTravel");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getReducedDamage(int CurrentDamage) {
		// TODO Auto-generated method stub
		return CurrentDamage;
	}

	@Override
	public void endTurnChange() {
		// TODO Auto-generated method stub
		this.setStack(this.getStack()-1);
	}

}
