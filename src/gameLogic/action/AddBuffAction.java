package gameLogic.action;

import gameLogic.ActionHandler;

/**
 * @author Napat
 * The action to add buff to buff Manager
 */
public class AddBuffAction extends ActionBase{
	private String buffCode;
	private int buffStack;
	public AddBuffAction(String targetType, String targetId,String buffCode,int buffStack) {
		super("Single", targetId);
		this.buffCode=buffCode;
		this.buffStack = buffStack;
	}
	public String getBuffCode() {
		return buffCode;
	}
	public void setBuffCode(String buffCode) {
		this.buffCode = buffCode;
	}
	public int getBuffStack() {
		return buffStack;
	}
	public void setBuffStack(int buffStack) {
		this.buffStack = buffStack;
	}
	/**
	 * InsertAddbuffAction into the queue
	 */
	@Override
	public void Activate() {
		// TODO Auto-generated method stub
		ActionHandler.addBuff(this.getBuffCode(),this.getBuffStack(), this.getTargetId());
	}
	
}