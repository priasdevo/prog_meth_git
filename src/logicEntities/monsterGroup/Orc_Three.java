package logicEntities.monsterGroup;

import java.util.ArrayList;

import logicEntities.Monsters.Goblin;
import logicEntities.Monsters.Orc;
import logicEntities.base.Monster;
import logicEntities.base.MonsterGroup;

/**
 * @author Napat
 * Monster group consist of 3 orc
 */
public class Orc_Three extends MonsterGroup{
	private final String id1 = "1st_Orc";
	private final int x1 = 11;
	private final int y1 = 7;

	private final String id2 = "2nd_Orc";
	private final int x2 = 7;
	private final int y2 = 5;

	private final String id3 = "3rd_Orc";
	private final int x3 = 3;
	private final int y3 = 7;


	public Orc_Three() {
		super();
		this.monsterGroup = new ArrayList<Monster>();
		this.monsterGroup.add(new Orc(this.id1,this.x1,this.y1));
		this.monsterGroup.add(new Orc(this.id2,this.x2,this.y2));
		this.monsterGroup.add(new Orc(this.id3,this.x3,this.y3));
	}
		
}