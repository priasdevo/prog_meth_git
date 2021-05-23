package gameLogic.statusEffect.specificStatusEffect.defenseApply;

import gameLogic.statusEffect.DefenseApplyStatusEffect;
import gameLogic.statusEffect.StatusEffectBase;

/**
 * @author Napat
 * Add 5 shield everytime the shield buff is gained
 */
public class CamelOfProficientDefense extends StatusEffectBase implements DefenseApplyStatusEffect{

	public CamelOfProficientDefense() {
		super(statusType,"Camel of Proficient Defense");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getDefenseBonus(int CurrentDefense) {
		// TODO Auto-generated method stub
		return 5*this.getStack();
	}

	@Override
	public void endTurnChange() {
		// TODO Auto-generated method stub
		//this.setStack(this.getStack()-1);
	}

}
