package gameLogic.statusEffect;

/**
 * @author Napat
 *The statusEffect that activate when entity geting damage
 */
public interface TakeDamageApplyStatuslEffect{

	static final int statusType = 2;
	public abstract int getReducedDamage(int CurrentDamage);
}
