package scene;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import shareObject.FirstSceneObjectHolder;
import shareObject.GameConfig;
import shareObject.SecondSceneObjectHolder;
import gameLogic.GameLogic;
import logicEntities.monsterGroup.*;
public class SecondScene extends Canvas{
	public SecondScene(double width,double height) {
		super(width,height);
		this.setVisible(true);
		addListener();
	}
	public void init(Scene scene) {
		GameLogic.setRoot(scene.lookup("#rootpane"));
		GameLogic.setGrid((GridPane) scene.lookup("#grid"));
		GameLogic.setCardBox( (HBox) scene.lookup("#cardBox") );
		GameLogic.init();
		GameLogic.getCardManager().renderHand();
		GameLogic.getMonsterManager().setMonsterList(new Slime_four().getMonsterGroup());
		GameLogic.getMonsterManager().renderMonster();
	}
	public void addListener() {
		
	}
	public void setScreen(Scene scene) {
		if(GameLogic.getActionManager().getActionList().size()!=0) {
			GameLogic.runAction();
		}
		
		Canvas canvas = (Canvas) scene.lookup("#SecondSceneBackground");
		GraphicsContext gc = canvas.getGraphicsContext2D();
		//gc.setFill(Color.BLACK);
		WritableImage croppedImage = new WritableImage(FirstSceneObjectHolder.fisrtSceneBackgroundImage.getPixelReader(),
				270, 90, GameConfig.screenWidth, GameConfig.screenHeight);
		gc.drawImage(croppedImage, 0, 0);
		if(SecondSceneObjectHolder.getInstance().getIsDragging()) {
			gc.beginPath();
			gc.moveTo(SecondSceneObjectHolder.getInstance().getCardX(), SecondSceneObjectHolder.getInstance().getCardY());
			gc.quadraticCurveTo(SecondSceneObjectHolder.getInstance().getCardX(), SecondSceneObjectHolder.getInstance().getCardY()-GameConfig.cardHeight/2, SecondSceneObjectHolder.getInstance().getCurrentX(), SecondSceneObjectHolder.getInstance().getCurrentY());
			gc.stroke();
			
		}
		
	}
}
