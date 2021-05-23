package gameLogic.statusEffect.specificStatusEffect.takeDamageApply;

import gameLogic.statusEffect.StatusEffectBase;
import gameLogic.statusEffect.TakeDamageApplyStatuslEffect;

/**
 * @author Napat
 * Status effect that protect the player from being damage
 */
public class Shield extends StatusEffectBase implements TakeDamageApplyStatuslEffect{
	public Shield() {
		super(statusType,"Shield");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getReducedDamage(int CurrentDamage) {
		// TODO Auto-generated method stub
		if(CurrentDamage>this.getStack()) {
			int stack = this.getStack();
			this.setStack(0);
			return stack;
		}else {
			this.setStack(this.getStack()-CurrentDamage);
			return CurrentDamage;
		}
	}

	@Override
	public void endTurnChange() {
		// TODO Auto-generated method stub
		//this.setStack(this.getStack()-1);
	}

}
