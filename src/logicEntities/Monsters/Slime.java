package logicEntities.Monsters;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logicEntities.base.Monster;
public class Slime extends Monster{
	public Slime( String monster_id) {
		super("Slime", monster_id, 20);
		// TODO Auto-generated constructor stub
		this.monster_height = 200 ;
		this.monster_width = 300 ;
		this.moster_image = new Image(ClassLoader.getSystemResource("secondScene/images/slime_blank.png").toString());
		this.monster_ob.setFitHeight(monster_height);
		this.monster_ob.setFitWidth(monster_width);
		this.monster_ob.setImage(moster_image);
	}

	public Slime(String monster_id,int posx,int posy) {
		super("Slime", monster_id, 20);
		// TODO Auto-generated constructor stub
		this.monster_height = 75 ;
		this.monster_width = 100 ;
		this.monster_xpos=posx;
		this.monster_ypos=posy;
		this.moster_image = new Image(ClassLoader.getSystemResource("secondScene/images/slime_blank.png").toString());
		// TODO Auto-generated constructor stub
		this.monster_ob.setFitHeight(monster_height);
		this.monster_ob.setFitWidth(monster_width);
		this.monster_ob.setImage(moster_image);
		//this.monster_ob = new ImageView();
		this.updateHp();
		this.monster_box.setAlignment(Pos.CENTER);
		/*ImageView test_ob = new ImageView();
		test_ob.setFitHeight(40);
		test_ob.setFitWidth(64);
		test_ob.setImage(moster_image);
		Pane test_pane = new Pane();
		test_pane.getChildren().add(test_ob);
		test_pane.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		System.out.println(test_pane.getPrefHeight()+test_pane.getPrefWidth());*/
		this.monster_box.getChildren().addAll(this.monster_ob,this.monster_hp_bar);
		
		}
	
	@Override
	public void action() {
		
		// TODO Auto-generated method stub
		
	}
	
}
