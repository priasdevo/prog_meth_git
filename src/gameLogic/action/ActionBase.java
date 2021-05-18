package gameLogic.action;

public abstract class ActionBase {
	protected String targetType;
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
	
}
