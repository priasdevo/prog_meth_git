package shareObject;

public class StageIndex {
	
	private static final StageIndex instance = new StageIndex();
	private int stageIndex;
	public int getstageIndex() {
		return stageIndex;
	}
	public void setstageIndex(int newStageIndex) {
		this.stageIndex = newStageIndex;
	}
	public static StageIndex getInstance() {
		return instance;
	}
}
