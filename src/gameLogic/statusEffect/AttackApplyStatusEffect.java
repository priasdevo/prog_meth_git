package gameLogic.statusEffect;

public abstract class AttackApplyStatusEffect extends StatusEffectBase{

	public AttackApplyStatusEffect( String name) {
		super(0, name);
		// TODO Auto-generated constructor stub
	}
	public abstract int getAttackBonus(int CurrentAttackDamage);
}
