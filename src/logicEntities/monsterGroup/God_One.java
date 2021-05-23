package logicEntities.monsterGroup;

import java.util.ArrayList;

import logicEntities.Monsters.Dragon;
import logicEntities.Monsters.God;
import logicEntities.base.Monster;
import logicEntities.base.MonsterGroup;

/**
 * @author Napat
 * The monster group consist of 1 god
 */
public class God_One extends MonsterGroup{
	private final String id1 = "1st_God";
	private final int x1 = 5;
	private final int y1 = 5;

	public God_One() {
		super();
		this.monsterGroup = new ArrayList<Monster>();
		this.monsterGroup.add(new God(this.id1,this.x1,this.y1));
	}
		
}