package logicEntities.base;

public class Monster {
	protected String name;
	protected String monster_id;
	protected int hp;
	
	public Monster(String name, int hp) {
		super();
		this.name = name;
		this.hp = hp;
	}
	public String getMonster_id() {
		return monster_id;
	}
	public void setMonster_id(String monster_id) {
		this.monster_id = monster_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}

}
