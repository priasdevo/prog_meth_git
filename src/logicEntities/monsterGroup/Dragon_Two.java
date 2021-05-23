package logicEntities.monsterGroup;

import java.util.ArrayList;

import logicEntities.Monsters.Dragon;
import logicEntities.Monsters.Orc;
import logicEntities.base.Monster;
import logicEntities.base.MonsterGroup;

/**
 * @author Napat
 * The monster group consist of 2 dragon
 */
public class Dragon_Two extends MonsterGroup{
	private final String id1 = "1st_Dragon";
	private final int x1 = 8;
	private final int y1 = 7;

	private final String id2 = "2nd_Dragon";
	private final int x2 = 3;
	private final int y2 = 7;

	public Dragon_Two() {
		super();
		this.monsterGroup = new ArrayList<Monster>();
		this.monsterGroup.add(new Dragon(this.id1,this.x1,this.y1));
		this.monsterGroup.add(new Dragon(this.id2,this.x2,this.y2));
	}
		
}