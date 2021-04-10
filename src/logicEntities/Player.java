package logicEntities;
import gameLogic.GameLogic;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import logicEntities.base.Affinity;
import shareObject.GameConfig;
public class Player {
	private static final Player instance = new Player();
	private int hp;
	private int mana;
	private int hp_max;
	private int mana_max;
	private double attackMultiply;
	private double defenseMultiply;
	private double controlMultiply;
	private int baseLevel;
	private Affinity affinity;
	private HBox statBar;
	private Label current_hp;
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
	public static Player getInstance() {
		return instance;
	}
	public void initBasicPlayer() {
		this.statBar = new HBox();
		this.current_hp = new Label();
		this.mana_GUI = new Label();
		this.hp = 100;
		this.hp_max = 100;
		this.mana = 100;
		this.mana_max = 100;
		this.attackMultiply = 1;
		this.defenseMultiply = 1;
		this.controlMultiply = 1;
		this.baseLevel = 1;
		this.affinity = new Affinity(1,1,1,1,1,1,1);
		this.setupStatBar();
		this.setupManacrystal();
	}
	public void setupStatBar() {
		this.statBar.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		this.current_hp.setText(Integer.toString(hp)+"/"+Integer.toString(hp_max));
		GameLogic.getGrid().add(statBar, 0, 0,16,1);
		this.statBar.getChildren().add(current_hp);
	}
	public void setupManacrystal() {
		ImageView manacrytal = new ImageView(new Image(ClassLoader.getSystemResource("secondScene/images/Mana_crystal.png").toString()));
		manacrytal.setFitHeight(GameConfig.screenHeight/16+10);
		manacrytal.setFitWidth(GameConfig.screenWidth/16);
		this.mana_GUI.setGraphic( manacrytal);
		this.mana_GUI.setText(Integer.toString(mana)+"/"+Integer.toString(mana_max));
		this.mana_GUI.setContentDisplay(ContentDisplay.CENTER);
		////this.mana_GUI.setMaxHeight(40);
		//this.mana_GUI.setMaxWidth(40);
		GameLogic.getGrid().add(mana_GUI, 1, 10);
	}
	public void updateMana() {
		this.mana_GUI.setText(Integer.toString(mana)+"/"+Integer.toString(mana_max));
	}
	public void updateHp() {
		this.current_hp.setText(Integer.toString(hp)+"/"+Integer.toString(hp_max));
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
	public void setMana(int mana) {
		this.mana = mana;
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

	
	
	
}
