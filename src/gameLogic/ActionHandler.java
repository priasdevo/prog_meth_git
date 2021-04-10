package gameLogic;
import logicEntities.base.*;
import logicEntities.Player;
public class ActionHandler {
	public static void attackTarget(int damage,String targetId) {
		if(targetId.equals("Player")) {
			System.out.println("Player please dieeee");
			Player.getInstance().setHp(Player.getInstance().getHp()-damage);
			Player.getInstance().updateHp();
			System.out.println();
		}
		else {
			for(Monster monster : GameLogic.getMonsterManager().getMonsterList()) {
				if(monster.getMonster_id().equals(targetId)) {
					monster.setHp(monster.getHp()-damage);
				}
				monster.updateHp();
			}
		}
		
		
	}
}
