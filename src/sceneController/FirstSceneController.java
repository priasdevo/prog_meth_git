package sceneController;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.util.Duration;
import gameLogic.GameLogic;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import shareObject.GameSaved;
import shareObject.StageIndex;
/**
 * @author Napat
 * Init basic constructor for main menu
 */
public class FirstSceneController{
	@FXML
	public Button startButton;
	public Canvas firstBackgroundCanvas;
	@FXML
	public void initialize() {
		// TODO Auto-generated method stub
		//firstBackgroundCanvas = new Canvas(640,480);
		//System.out.println("Controller bind successfully");
	}
	/**
	 * Exit game
	 */
	public void exitApplication() {
		//System.out.print("Clicked");
		Platform.exit();
	}
	/**
	 * Move to battle scene
	 */
	public void startScene() {
		FadeTransition ft = new FadeTransition(Duration.millis(1000),(Node) GameLogic.getRoot());
	     ft.setFromValue(1.0);
	     ft.setToValue(0.1);
	     ft.setOnFinished(e -> changeScene());
	     ft.play();
		//System.out.print("Clicked");
		//StageIndex.getInstance().setstageIndex(1);
	}
	public void deleteSave() {
		GameSaved.clear();
		Platform.exit();
	}
	public void changeScene() {
		//System.out.print("Clicked");
		StageIndex.getInstance().setstageIndex(StageIndex.battle);
	}

}
