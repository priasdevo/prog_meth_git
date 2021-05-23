package gameLogic;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import exception.NoTargetExcaption;
import gameLogic.action.*;
import javafx.application.Platform;
import logicEntities.base.Monster;

/**
 * @author Napat
 * The place to Queue the Action to be handle
 */
public class ActionManager {
	private ArrayList<ActionBase> actionList;
	private ArrayList<ActionBase> addLater;
	/**
	 * Init all field
	 */
	public ActionManager() {
		super();
		this.actionList = new ArrayList<ActionBase>();
	}
	/**
	 * Handle each action
	 */
	public void runAction() {
		for(ActionBase action: this.actionList) {
			try {
				action.Activate();
			}catch(NoTargetExcaption e) {
				// set Target to 1 monster in the list
				action.setTargetId(GameLogic.getMonsterManager().getMonsterList().get(0).getMonster_id());
				Platform.runLater(()->{
					this.actionList.add(action);
				});
			}
			
		}
		GameLogic.getActionManager().clear();
		try {
			GameLogic.getMonsterManager().clearMonster();
		}
		catch(ConcurrentModificationException e){
			
		}
		GameLogic.setActionRunning(false);
	}
	
	/**
	 * Add action to the queue
	 * @param action
	 */
	public void add(ActionBase action) {
		actionList.add(action);
	}

	/**
	 * Clear the action in queue
	 */
	public void clear() {
		actionList.clear();
	}
	/**
	 * @return All the action in queue
	 */
	public ArrayList<ActionBase> getActionList() {
		return actionList;
	}
	/**
	 * set the action List
	 * @param actionList
	 */
	public void setActionList(ArrayList<ActionBase> actionList) {
		this.actionList = actionList;
	}

	
	
}
