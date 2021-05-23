package gameLogic.action;

import gameLogic.ActionHandler;
import gameLogic.GameLogic;
import logicEntities.base.Monster;

/**
 * @author Napat
 * The action to deal damage to all monster(Bonus attack not working)
 */
public class DealAllDamage extends ActionBase{
	private int damage;
	public DealAllDamage(String targetType,int damage) {
		super(targetType);
		this.damage=damage;
		// TODO Auto-generated constructor stub
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	@Override
	public void Activate() {
		for(Monster monster : GameLogic.getMonsterManager().getMonsterList()) {
			ActionHandler.dealDamage(this.getDamage(), monster.getMonster_id());
		}
		// TODO Auto-generated method stub
		
	}
}