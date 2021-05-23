package gameLogic.action;

import exception.NoTargetExcaption;

/**
 * @author Napat
 * The template for all action
 */
public abstract class ActionBase {
	/**
	 * The type of target suchas single,all
	 */
	protected String targetType;
	/**
	 * The Id of Target
	 */
	protected String targetId;
	
	public ActionBase(String targetType, String targetId) {
		super();
		this.targetType = targetType;
		this.targetId = targetId;
	}
	public ActionBase(String targetType) {
		super();
		this.targetType = targetType;
	}
	public String getTargetType() {
		return targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public abstract void Activate() throws NoTargetExcaption;
}
