package logicEntities.base;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * @author Napat
 * Base template for monster
 */
public abstract class Monster {
	protected String name;
	protected String monster_id;
	protected int hp;
	protected int hp_max;
	protected Image moster_image;
	protected int monster_width;
	protected int monster_height;
	protected int monster_xpos;
	protected int monster_ypos;
	protected ImageView monster_ob;
	protected VBox monster_box;
	protected Label monster_hp_bar;
	protected ProgressBar monster_hp_bar_progress;
	public Monster(String name, String monster_id, int hp) {
		super();
		this.monster_hp_bar_progress = new ProgressBar();
		this.monster_hp_bar = new Label();
		this.monster_box = new VBox();
		this.name = name;
		this.monster_id = monster_id;
		this.hp = hp;
		this.hp_max = hp;
		this.monster_ob = new ImageView();
		this.monster_box.setSpacing(1);
	}
	/**
	 * The action at each monster turn
	 */
	public abstract void action();
	/**
	 * Update Hp of monster
	 */
	public void updateHp() {
		double hps = this.hp;
		
		//this.monster_hp_bar.setPadding(new Insets(5));
		Platform.runLater(()->{
			this.monster_hp_bar_progress.setProgress(hps/this.hp_max);
			this.monster_hp_bar.setGraphic(this.monster_hp_bar_progress);
			this.monster_hp_bar.setContentDisplay(ContentDisplay.CENTER);
			this.monster_hp_bar.setText( Integer.toString(this.hp)+"/"+Integer.toString(this.hp_max) );
		});
		
	}
	
	
	public String getMonster_id() {
		return monster_id;
	}
	public void setMonster_id(String monster_id) {
		this.monster_id = monster_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public Image getMoster_image() {
		return moster_image;
	}
	public void setMoster_image(Image moster_image) {
		this.moster_image = moster_image;
	}
	public int getMonster_width() {
		return monster_width;
	}
	public void setMonster_width(int monster_width) {
		this.monster_width = monster_width;
	}
	public int getMonster_height() {
		return monster_height;
	}
	public void setMonster_height(int monster_height) {
		this.monster_height = monster_height;
	}

	public int getMonster_xpos() {
		return monster_xpos;
	}

	public void setMonster_xpos(int monster_xpos) {
		this.monster_xpos = monster_xpos;
	}

	public int getMonster_ypos() {
		return monster_ypos;
	}

	public void setMonster_ypos(int monster_ypos) {
		this.monster_ypos = monster_ypos;
	}

	public ImageView getMonster_ob() {
		return monster_ob;
	}

	public void setMonster_ob(ImageView monster_ob) {
		this.monster_ob = monster_ob;
	}
	public VBox getMonster_box() {
		return monster_box;
	}
	public void setMonster_box(VBox monster_box) {
		this.monster_box = monster_box;
	}
	public Label getMonster_hp_bar() {
		return monster_hp_bar;
	}
	public void setMonster_hp_bar(Label monster_hp_bar) {
		this.monster_hp_bar = monster_hp_bar;
	}
	
}
