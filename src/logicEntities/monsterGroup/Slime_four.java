package logicEntities.monsterGroup;
import logicEntities.base.*;

import java.util.ArrayList;

import logicEntities.Monsters.*;
public class Slime_four extends MonsterGroup{

	public Slime_four() {
		super();
		this.monsterGroup = new ArrayList<Monster>();
		this.monsterGroup.add(new Slime("1st_Slime",11,7));
		this.monsterGroup.add(new Slime("2nd_Slime",8,5));
		this.monsterGroup.add(new Slime("3rd_Slime",5,5));
		this.monsterGroup.add(new Slime("4th_Slime",2,7));
	}
		
}
