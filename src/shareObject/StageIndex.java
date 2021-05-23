package shareObject;

/**
 * @author Napat
 * Indicate which stage are playing now
 */
public class StageIndex {
	
	private static final StageIndex instance = new StageIndex();
	public static final int prepare = -1;
	public static final int mainMenu = 0;
	public static final int battle = 1;
	public static final int Transition = 2;
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
