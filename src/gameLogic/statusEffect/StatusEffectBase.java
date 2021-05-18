package gameLogic.statusEffect;

public abstract class StatusEffectBase {
	/*
	 * Attack use Appli = 0
	 * Defense add Appli = 1
	 * Take Damage Appli = 2
	 * Card use = 3
	 */
	private int type;
	
	// SpecialEffect_name
	private String name;
	
	// The amount of special Effect Stack
	private int stack;
	
	public StatusEffectBase(int type, String name) {
		super();
		this.type = type;
		this.name = name;
		this.stack = 0;
	}
	public abstract void endTurnChange();
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStack() {
		return stack;
	}

	public void setStack(int stack) {
		this.stack = stack;
	}
	
}
