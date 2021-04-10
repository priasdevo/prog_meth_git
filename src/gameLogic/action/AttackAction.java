package gameLogic.action;

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
	
}
