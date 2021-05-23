package logicEntities.monsterGroup;

import java.util.ArrayList;

import logicEntities.Monsters.Goblin;
import logicEntities.Monsters.Slime;
import logicEntities.base.Monster;
import logicEntities.base.MonsterGroup;

/**
 * @author Napat
 * The monster group consist of 4 goblin
 */
public class Goblin_four extends MonsterGroup{
	private final String id1 = "1st_Goblin";
	private final int x1 = 11;
	private final int y1 = 7;

	private final String id2 = "2nd_Goblin";
	private final int x2 = 8;
	private final int y2 = 5;

	private final String id3 = "3rd_Goblin";
	private final int x3 = 5;
	private final int y3 = 5;

	private final String id4 = "4th_Goblin";
	private final int x4 = 2;
	private final int y4 = 7;
	public Goblin_four() {
		super();
		this.monsterGroup = new ArrayList<Monster>();
		this.monsterGroup.add(new Goblin(this.id1,this.x1,this.y1));
		this.monsterGroup.add(new Goblin(this.id2,this.x2,this.y2));
		this.monsterGroup.add(new Goblin(this.id3,this.x3,this.y3));
		this.monsterGroup.add(new Goblin(this.id4,this.x4,this.y4));
	}
		
}
