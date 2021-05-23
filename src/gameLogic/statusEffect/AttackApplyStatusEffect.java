package gameLogic.statusEffect;

/**
 * @author Napat
 * The statusEffect that activate when attack action is being handle
 */
public interface AttackApplyStatusEffect{
	static final int statusType = 0;
	public abstract int getAttackBonus(int CurrentAttackDamage);
}
