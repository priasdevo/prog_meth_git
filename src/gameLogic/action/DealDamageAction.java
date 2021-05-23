package gameLogic.action;

import gameLogic.ActionHandler;

/**
 * @author Napat
 * Deal damage to specifin monster(BonusDamage not working)
 */
public class DealDamageAction extends ActionBase{
	private int damage;
	public DealDamageAction(String targetType, String targetId,int damage) {
		super(targetType, targetId);
		this.damage=damage;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	@Override
	public void Activate() {
		// TODO Auto-generated method stub
		ActionHandler.dealDamage(damage, targetId);
	}
	
}
