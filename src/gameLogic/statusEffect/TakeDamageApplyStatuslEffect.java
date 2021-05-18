package gameLogic.statusEffect;

public abstract class TakeDamageApplyStatuslEffect extends StatusEffectBase{

	public TakeDamageApplyStatuslEffect( String name) {
		super(2, name);
		// TODO Auto-generated constructor stub
	}
	public abstract int getReducedDamage(int CurrentDamage);
}
