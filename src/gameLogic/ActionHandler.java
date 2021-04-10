package gameLogic;
import logicEntities.base.*;
public class ActionHandler {
	public static void attackTarget(int damage,String targetId) {
		for(Monster monster : GameLogic.getMonsterManager().getMonsterList()) {
			if(monster.getMonster_id().equals(targetId)) {
				monster.setHp(monster.getHp()-damage);
			}
			monster.updateHp();
		}
	}
}
