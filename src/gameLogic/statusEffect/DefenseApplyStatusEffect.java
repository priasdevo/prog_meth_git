package gameLogic.statusEffect;

public abstract class DefenseApplyStatusEffect extends StatusEffectBase{

	public DefenseApplyStatusEffect(String name) {
		super(1, name);
		// TODO Auto-generated constructor stub
	}
	public abstract int getDefenseBonus(int CurrentDefense);

}
