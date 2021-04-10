package gameLogic;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import gameLogic.action.ActionBase;
import gameLogic.action.AttackAction;

public class ActionManager {
	private ArrayList<ActionBase> actionList;
	public ActionManager() {
		super();
		this.actionList = new ArrayList<ActionBase>();
	}
	public void runAction() {
		for(ActionBase action: this.actionList) {
			if(action instanceof AttackAction) {
				ActionHandler.attackTarget(((AttackAction) action).getDamage(), action.getTargetId());
			}
			
		}
		GameLogic.getActionManager().clear();
		try {
			GameLogic.getMonsterManager().clearMonster();
		}
		catch(ConcurrentModificationException e){
			
		}
		
	}
	
	public void add(ActionBase action) {
		actionList.add(action);
	}
	public void clear() {
		actionList.clear();
	}
	public ArrayList<ActionBase> getActionList() {
		return actionList;
	}
	public void setActionList(ArrayList<ActionBase> actionList) {
		this.actionList = actionList;
	}

	
	
}
