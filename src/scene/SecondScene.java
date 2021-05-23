package scene;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import shareObject.BackgroundImageHolder;
import shareObject.GameConfig;
import shareObject.MousePositionPointer;
import shareObject.SoundHolder;
import gameLogic.GameLogic;
import logicEntities.Player;
import logicEntities.monsterGroup.*;
/**
 * @author Napat
 * Battle Scene
 */
public class SecondScene extends Canvas{
	private final int startPoint = 0 ;
	private boolean isGameEnd = false;
	public SecondScene(double width,double height) {
		super(width,height);
		this.setVisible(true);
	}
	/**
	 * Init the battle scene
	 * @param scene
	 */
	public void init(Scene scene) {
		GameLogic.setRoot(scene.lookup("#rootpane2"));
		GameLogic.setGrid((GridPane) scene.lookup("#grid"));
		GameLogic.setCardBox( (HBox) scene.lookup("#cardBox") );
		GameLogic.init();
		GameLogic.getCardManager().renderHand();
		switch(GameLogic.getRound()) {
		case 0:
			GameLogic.getMonsterManager().setMonsterList(new Slime_four().getMonsterGroup());
			break;
		case 1:
			GameLogic.getMonsterManager().setMonsterList(new Goblin_four().getMonsterGroup());
			break;
		case 2:
			GameLogic.getMonsterManager().setMonsterList(new Orc_Three().getMonsterGroup());
			break;
		case 3:
			GameLogic.getMonsterManager().setMonsterList(new Dragon_Two().getMonsterGroup());
			break;
		case 4:
			GameLogic.getMonsterManager().setMonsterList(new God_One().getMonsterGroup());
			break;
		}
		
		GameLogic.getMonsterManager().renderMonster();
		Player.getInstance().setupStatBar();
		Player.getInstance().setupManacrystal();
	}
	/**
	 * Render the changed screen and Run action
	 * @param scene
	 */
	public void setScreen(Scene scene) {
		if(GameLogic.getActionManager().getActionList().size()!=0 && !GameLogic.isActionRunning()) {
			//System.out.println("COUNT");
			new Thread(()->{
				GameLogic.setActionRunning(true);
				GameLogic.runAction();
			//GameLogic.getActionManager().move();
			}).start();
			
		}
		if(GameLogic.getMonsterManager().getMonsterList().size() == 0 && !isGameEnd) {
			isGameEnd = true;
			FadeTransition ft = new FadeTransition(Duration.millis(1000),(Node) GameLogic.getRoot());
		     ft.setFromValue(1.0);
		     ft.setToValue(0.1);
		     ft.setOnFinished(e ->{
		    	 GameLogic.setRound(GameLogic.getRound()+1);
		    	 GameLogic.gameTransition(GameConfig.winResult);
		    	 isGameEnd = false;
		     });
		     ft.play();
		    
		}else if(Player.getInstance().getHp()<=0 && !isGameEnd) {
			isGameEnd = true;
			FadeTransition ft = new FadeTransition(Duration.millis(1000),(Node) GameLogic.getRoot());
		     ft.setFromValue(1.0);
		     ft.setToValue(0.1);
		     ft.setOnFinished(e -> {
		    	 GameLogic.gameTransition(GameConfig.loseResult);
		    	 isGameEnd = false;
		     });
		     ft.play();
		     
		}
		
		Canvas canvas = (Canvas) scene.lookup("#SecondSceneBackground");
		GraphicsContext gc = canvas.getGraphicsContext2D();
		//gc.setFill(Color.BLACK);
		WritableImage croppedImage = new WritableImage(BackgroundImageHolder.battleBackground.getPixelReader(),
				0, 0, GameConfig.screenWidth, GameConfig.screenHeight);
		
		gc.drawImage(croppedImage, startPoint, startPoint);
		if(MousePositionPointer.getInstance().getIsDragging()) {
			gc.beginPath();
			gc.moveTo(MousePositionPointer.getInstance().getCardX(), MousePositionPointer.getInstance().getCardY());
			gc.quadraticCurveTo(MousePositionPointer.getInstance().getCardX(), MousePositionPointer.getInstance().getCardY()-GameConfig.cardHeight/2, MousePositionPointer.getInstance().getCurrentX(), MousePositionPointer.getInstance().getCurrentY());
			gc.stroke();
			
		}
		
	}
}
