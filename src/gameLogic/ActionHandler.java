package gameLogic;
import logicEntities.base.*;
import shareObject.BuffCodeHolder;
import gameLogic.statusEffect.*;
import gameLogic.statusEffect.specificStatusEffect.attackApply.*;
import gameLogic.statusEffect.specificStatusEffect.cardUseApplay.*;
import gameLogic.statusEffect.specificStatusEffect.defenseApply.*;
import gameLogic.statusEffect.specificStatusEffect.takeDamageApply.*;
import logicEntities.Player;
/**
 * @author Napat
 * Class for Handle (Queue) for action
 */
public class ActionHandler {
	/**
	 * Attack the the entity
	 * @param damage initial damage without buff
	 * @param targetId id of target entity
	 */
	public static void attackTarget(int damage,String targetId) {
		
		if(targetId.equals("Player")) {
			int decreaseDamage = BuffManager.getRedeucedDamage(damage);
			//System.out.println("Player please dieeee");
			//System.out.println(decreaseDamage);
			Player.getInstance().setHp(Player.getInstance().getHp()-damage+decreaseDamage);
			Player.getInstance().updateHp();
			//System.out.println();
		}
		else {
			int increaseDamage = BuffManager.getDamageBuff(damage);
			for(Monster monster : GameLogic.getMonsterManager().getMonsterList()) {
				if(monster.getMonster_id().equals(targetId)) {
					monster.setHp(monster.getHp()-damage-increaseDamage);
				}
				monster.updateHp();
			}
		}
	}
	/**
	 * Heal the target entity
	 * @param healAmount the amout of heal target will recieve without buff
	 * @param targetId the id of target entity
	 */
	public static void healTarget(int healAmount,String targetId) {
		if(targetId.equals("Player")) {
			//System.out.println("Player please dieeee");
			Player.getInstance().setHp(Player.getInstance().getHp()+healAmount);
			Player.getInstance().updateHp();
			//System.out.println();
		}
		else {
			for(Monster monster : GameLogic.getMonsterManager().getMonsterList()) {
				if(monster.getMonster_id().equals(targetId)) {
					monster.setHp(monster.getHp()+healAmount);
				}
				monster.updateHp();
			}
		}
	}
	/**
	 * @param damage initial damage without buff
	 * @param targetId id of target entity
	 */
	public static void dealDamage(int damage,String targetId) {
		
		if(targetId.equals("Player")) {
			//System.out.println("Player please dieeee");
			Player.getInstance().setHp(Player.getInstance().getHp()-damage);
			Player.getInstance().updateHp();
			//System.out.println();
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
	/**
	 * @param buffCode The code of the buff that will be added (Refer to BuufCodeHolder)
	 * @param buffStack The stack of the buff that will be added
	 * @param targetId The target entity
	 */
	public static void addBuff(String buffCode,int buffStack,String targetId) {
		if(targetId.equals("Player")) {
			// Get Buff from buffCode
			StatusEffectBase decryptbuff = null;
			switch(buffCode) {
			case BuffCodeHolder.Bull_of_Power:
				decryptbuff = new BullOfPower();
				break;
			case BuffCodeHolder.Camel_of_Proficient_Attack:
				decryptbuff = new CamelOfProficientAttack();
				break;
			case BuffCodeHolder.Magic_Aggregation:
				decryptbuff = new MagicAggregation();
				break;
			case BuffCodeHolder.ThunderGoat:
				decryptbuff = new ThunderGoat();
				break;
			case BuffCodeHolder.WindOfRaptor:
				decryptbuff = new WindOfRaptor();
				break;
			case BuffCodeHolder.Camel_of_Proficient_Defense:
				decryptbuff = new CamelOfProficientDefense();
				break;
			case BuffCodeHolder.Gale_of_Travel:
				decryptbuff = new GaleOfTravel();
				break;
			case BuffCodeHolder.Shield:
				decryptbuff = new Shield();
				break;
			}
			if(decryptbuff!=null) {
				if(decryptbuff instanceof Shield) {
					buffStack+=BuffManager.getShieldBuff(buffStack);
				}
				decryptbuff.setStack(buffStack);
				BuffManager.addBuff(decryptbuff);
			}
			
			
		}
	}
	
}
