package gameLogic.action;

import gameLogic.ActionHandler;

/**
 * @author Napat
 * Heal specific target
 */
public class HealAction extends ActionBase{
	private int healAmount;
	public HealAction(String targetType,String targetId,int healAmount) {
		super(targetType,targetId);
		this.healAmount = healAmount;
		// TODO Auto-generated constructor stub
	}
	public int getHealAmount() {
		return healAmount;
	}
	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}
	@Override
	public void Activate() {
		// TODO Auto-generated method stub
		ActionHandler.healTarget(this.getHealAmount(), this.getTargetId());
	}
	
}
