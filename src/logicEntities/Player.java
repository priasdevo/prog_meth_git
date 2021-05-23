package logicEntities;
import gameLogic.BuffManager;
import gameLogic.GameLogic;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import logicEntities.base.Affinity;
import shareObject.GameConfig;
import shareObject.GameSaved;
/**
 * @author Napat
 * Class of Player
 */
public class Player {
	private static final Player instance = new Player();
	private int hp;
	private int mana;
	private int hp_max;
	private int mana_max;
	private double attackMultiply;
	private double defenseMultiply;
	private double controlMultiply;
	private final int startHP = 100;
	private final int startMP = 5;
	private int baseLevel;
	private Affinity affinity;
	private HBox statBar;
	private Label current_hp;
	private Label current_buff;
	private Label mana_GUI;
	{
		initBasicPlayer();
	}
	
	/*public Player(int hp, int mana, double attackMultiply, double defenseMultiply, double controlMultiply,
			int baseLevel, Affinity affinity) {
		super();
		this.hp = hp;
		this.mana = mana;
		this.attackMultiply = attackMultiply;
		this.defenseMultiply = defenseMultiply;
		this.controlMultiply = controlMultiply;
		this.baseLevel = baseLevel;
		this.affinity = affinity;
	}*/
	/**
	 * @return player's instance
	 */
	public static Player getInstance() {
		return instance;
	}
	/**
	 * Create the player with specific Value
	 */
	public void initBasicPlayer() {
		this.statBar = new HBox();
		this.current_hp = new Label();
		this.mana_GUI = new Label();
		this.current_buff = new Label();
		this.hp_max = this.startHP + 10*GameSaved.getPlayer_level();
		this.hp = this.hp_max;
		
		this.mana_max = this.startMP + Math.round(GameSaved.getPlayer_level()/5);
		this.mana = this.mana_max;
		
		/*this.attackMultiply = 1;
		this.defenseMultiply = 1;
		this.controlMultiply = 1;
		this.baseLevel = 1;
		this.affinity = new Affinity(1,1,1,1,1,1,1);*/
		this.statBar.setMaxHeight(20);
		this.statBar.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		//this.statBar.setGraphic(new ImageView(BackgroundImageHolder.textBackground));
		this.current_hp.setText(Integer.toString(hp)+"/"+Integer.toString(hp_max));
		this.statBar.getChildren().addAll(current_hp,current_buff);
		
	}
	/**
	 * Set up the player statbar in battle scene (consist of hp and buff list)
	 */
	public void setupStatBar() {
		GameLogic.getGrid().add(statBar, 0, 0,16,1);
		GridPane.setValignment(statBar, VPos.TOP);
		}
	/**
	 * Set up player manacrystal in battle scene
	 */
	public void setupManacrystal() {
		ImageView manacrytal = new ImageView(new Image(ClassLoader.getSystemResource("cardImage/Mana_crystal.png").toString()));
		manacrytal.setFitHeight(GameConfig.screenHeight/16+10);
		manacrytal.setFitWidth(GameConfig.screenWidth/16);
		this.mana_GUI.setGraphic( manacrytal);
		this.mana_GUI.setText(Integer.toString(mana)+"/"+Integer.toString(mana_max));
		this.mana_GUI.setContentDisplay(ContentDisplay.CENTER);
		////this.mana_GUI.setMaxHeight(40);
		//this.mana_GUI.setMaxWidth(40);
		GameLogic.getGrid().add(mana_GUI, 1, 10);
	}
	/**
	 * Update player's mana
	 */
	public void updateMana() {
		this.mana_GUI.setText(Integer.toString(mana)+"/"+Integer.toString(mana_max));
	}
	/**
	 * Update player's HP
	 */
	public void updateHp() {
		Platform.runLater(()->{
			this.current_hp.setText(Integer.toString(hp)+"/"+Integer.toString(hp_max));
		});
		
	}
	/**
	 * Update player buff
	 */
	public void updateBuff() {
		Platform.runLater(()->{
			this.current_buff.setText("     "+BuffManager.getBuffList());
			
		});
	}
	public void heal(int healed) {
		this.hp += healed;
	}
	public Affinity getAffinity() {
		return affinity;
	}
	public void setAffinity(Affinity affinity) {
		this.affinity = affinity;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMana() {
		return mana;
	}
	/**
	 * set the player's mana
	 * @param mana
	 */
	public void setMana(int mana) {
		this.mana = mana;
		Player.getInstance().updateMana();
	}
	public double getAttackMultiply() {
		return attackMultiply;
	}
	public void setAttackMultiply(double attackMultiply) {
		this.attackMultiply = attackMultiply;
	}
	public double getDefenseMultiply() {
		return defenseMultiply;
	}
	public void setDefenseMultiply(double defenseMultiply) {
		this.defenseMultiply = defenseMultiply;
	}
	public double getControlMultiply() {
		return controlMultiply;
	}
	public void setControlMultiply(double controlMultiply) {
		this.controlMultiply = controlMultiply;
	}
	public int getBaseLevel() {
		return baseLevel;
	}
	public void setBaseLevel(int baseLevel) {
		this.baseLevel = baseLevel;
	}
	public int getHp_max() {
		return hp_max;
	}
	public void setHp_max(int hp_max) {
		this.hp_max = hp_max;
	}
	public int getMana_max() {
		return mana_max;
	}
	public void setMana_max(int mana_max) {
		this.mana_max = mana_max;
	}
	public HBox getStatBar() {
		return statBar;
	}
	public void setStatBar(HBox statBar) {
		this.statBar = statBar;
	}
	public Label getCurrent_hp() {
		return current_hp;
	}
	public void setCurrent_hp(Label current_hp) {
		this.current_hp = current_hp;
	}
	public Label getMana_GUI() {
		return mana_GUI;
	}
	public void setMana_GUI(Label mana_GUI) {
		this.mana_GUI = mana_GUI;
	}

	
	
	
}
