package gameLogic.statusEffect;

/**
 * @author Napat
 *The statusEffect that activate when defense action is being handle
 */
public interface DefenseApplyStatusEffect{
	static final int statusType = 1;
	public abstract int getDefenseBonus(int CurrentDefense);

}
