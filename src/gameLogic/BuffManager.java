package gameLogic;

import java.util.ArrayList;

import gameLogic.statusEffect.AttackApplyStatusEffect;
import gameLogic.statusEffect.CardUseApplyStatusEffect;
import gameLogic.statusEffect.DefenseApplyStatusEffect;
import gameLogic.statusEffect.StatusEffectBase;
import gameLogic.statusEffect.TakeDamageApplyStatuslEffect;
import javafx.application.Platform;
import logicEntities.Player;
import logicEntities.base.Card;

/**
 * @author Napat
 * The class to manage all buff
 */
public class BuffManager {
	private static ArrayList<StatusEffectBase> allBuff = new ArrayList<StatusEffectBase>();
	private static ArrayList<AttackApplyStatusEffect> attackBuff = new ArrayList<AttackApplyStatusEffect>();
	private static ArrayList<CardUseApplyStatusEffect> cardUseBuff= new ArrayList<CardUseApplyStatusEffect>();
	private static ArrayList<DefenseApplyStatusEffect> defenseBuff= new ArrayList<DefenseApplyStatusEffect>();
	private static ArrayList<TakeDamageApplyStatuslEffect> takeDamageBuff = new ArrayList<TakeDamageApplyStatuslEffect>();
	public BuffManager() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Calculate the  increase damage from buff
	 * @param initialDamage
	 * @return the increase damage
	 */
	public static int getDamageBuff(int initialDamage) {
		int increaseDamage = 0;
		for(AttackApplyStatusEffect buff : attackBuff) {
			increaseDamage += buff.getAttackBonus(initialDamage);
			System.out.println(buff.getClass());
		}
		updateBuff();
		Player.getInstance().updateBuff();
		
		return increaseDamage;
	}
	/**
	 * Calculate the  increase Shield from buff
	 * @param initialShield
	 * @return the increase Shield
	 */
	public static int getShieldBuff(int initialShield) {
		int increaseShield = 0;
		for(DefenseApplyStatusEffect buff : defenseBuff) {
			increaseShield += buff.getDefenseBonus(initialShield);
			System.out.println(buff.getClass());
		}
		updateBuff();
		Player.getInstance().updateBuff();
		
		return increaseShield;
	}
	/**
	 * Calculate the  reduced damage from buff
	 * @param initialDamage
	 * @return reduce damage
	 */
	public static int getRedeucedDamage(int initialDamage) {
		int reducedDamage = 0;
		for(TakeDamageApplyStatuslEffect buff : takeDamageBuff) {
			if(reducedDamage>=initialDamage) {
				updateBuff();
				return initialDamage;
			}
			reducedDamage += buff.getReducedDamage(initialDamage);
			System.out.println(buff.getClass());
		}
		updateBuff();
		Player.getInstance().updateBuff();
		return reducedDamage;
	}
	/**
	 * Activate the buff that trigger when card are used
	 * @param usedCard Card that used to trigger this effect
	 */
	public static void cardUseBuffActivate(Card usedCard) {
		for(CardUseApplyStatusEffect buff : cardUseBuff) {
			buff.Activate(usedCard);
		}
		updateBuff();
		Player.getInstance().updateBuff();
	}
	/**
	 * Add buff to bufflist
	 * @param buff the buff that are being add
	 */
	public static void addBuff(StatusEffectBase buff) {
		boolean isThere = false;
		for(StatusEffectBase buffs : allBuff) {
			if(buff.getName().equals(buffs.getName())) {
				buffs.setStack(buffs.getStack()+buff.getStack());
				isThere=true;
			}
		}
		if(!isThere) {
			allBuff.add(buff);
			if(buff instanceof AttackApplyStatusEffect) {
				attackBuff.add((AttackApplyStatusEffect) buff);
			}else if(buff instanceof CardUseApplyStatusEffect) {
				cardUseBuff.add((CardUseApplyStatusEffect) buff);
			}else if(buff instanceof DefenseApplyStatusEffect) {
				defenseBuff.add((DefenseApplyStatusEffect) buff);
			}else if(buff instanceof TakeDamageApplyStatuslEffect) {
				takeDamageBuff.add((TakeDamageApplyStatuslEffect) buff);
			}
		}
		Player.getInstance().updateBuff();
	}
	/**
	 * Update the state of each buff
	 */
	public static void updateBuff() {
		for(StatusEffectBase buff : allBuff) {
			if(buff.getStack()<=0) {
				Platform.runLater(()->{
					allBuff.remove(buff);
					if(buff instanceof AttackApplyStatusEffect) {
						attackBuff.remove((AttackApplyStatusEffect) buff);
					}else if(buff instanceof CardUseApplyStatusEffect) {
						cardUseBuff.remove((CardUseApplyStatusEffect) buff);
					}else if(buff instanceof DefenseApplyStatusEffect) {
						defenseBuff.remove((DefenseApplyStatusEffect) buff);
					}else if(buff instanceof TakeDamageApplyStatuslEffect) {
						takeDamageBuff.remove((TakeDamageApplyStatuslEffect) buff);
					}
				});
				
			}
		}
		
		Player.getInstance().updateBuff();
	}
	/**
	 * @return the string that contain name and stack of each buff
	 */
	public static String getBuffList() {
		String ans = "";
		for(StatusEffectBase buff : allBuff) {
			ans += buff.getName()+" : "+buff.getStack()+", ";
		}
		//System.out.print(attackBuff);
		return ans;
	}
	/**
	 * Trigger the endTurn effect of each buff
	 */
	public static void endTurnChange() {
		for(StatusEffectBase buff : allBuff) {
			buff.endTurnChange();
			updateBuff();
		}
		Player.getInstance().updateBuff();
	}
	/**
	 * Clear all the buff
	 */
	public static void clear() {
		allBuff.clear();
		attackBuff.clear();
		defenseBuff.clear();
		cardUseBuff.clear();
		takeDamageBuff.clear();
		Player.getInstance().updateBuff();
	}
}
