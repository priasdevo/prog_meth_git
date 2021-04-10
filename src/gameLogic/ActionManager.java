package gameLogic;

import java.util.ArrayList;

import gameLogic.action.ActionBase;

public class ActionManager {
	private ArrayList<ActionBase> actionList;
	public ActionManager() {
		super();
		this.actionList = new ArrayList<ActionBase>();
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
