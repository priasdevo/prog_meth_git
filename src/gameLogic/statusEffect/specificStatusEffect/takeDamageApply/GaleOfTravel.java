package gameLogic.statusEffect.specificStatusEffect.takeDamageApply;

import gameLogic.statusEffect.StatusEffectBase;
import gameLogic.statusEffect.TakeDamageApplyStatuslEffect;

/**
 * @author Napat
 * Card gale of travel
 */
public class GaleOfTravel extends StatusEffectBase implements TakeDamageApplyStatuslEffect{

	public GaleOfTravel() {
		super(statusType,"Gale of Travel");
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
