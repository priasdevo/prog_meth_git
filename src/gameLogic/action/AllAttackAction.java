package gameLogic.action;

public class AllAttackAction extends ActionBase{
	private int damage;
	public AllAttackAction(String targetType,int damage) {
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
}
