package gameLogic.action;

import exception.NoTargetExcaption;
import gameLogic.ActionHandler;

/**
 * @author Napat
 *The action to attack specific monster
 */
public class AttackAction extends ActionBase{
	private int damage;
	public AttackAction(String targetType, String targetId,int damage) {
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
	public void Activate()  throws NoTargetExcaption{
		// TODO Auto-generated method stub
		if(this.getTargetId()==null) {
			throw new NoTargetExcaption();
		}
		ActionHandler.attackTarget(this.getDamage(), this.getTargetId());
	}
	
}
