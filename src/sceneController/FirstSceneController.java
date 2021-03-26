package sceneController;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.application.Platform;
import javafx.fxml.FXML;
import shareObject.StageIndex;
public class FirstSceneController{
	@FXML
	public Button startButton;
	public Canvas firstBackgroundCanvas;
	@FXML
	public void initialize() {
		// TODO Auto-generated method stub
		//firstBackgroundCanvas = new Canvas(640,480);
		System.out.println("Controller bind successfully");
	}
	public void exitApplication() {
		//System.out.print("Clicked");
		Platform.exit();
	}
	public void startScene() {
		System.out.print("Clicked");
		StageIndex.getInstance().setstageIndex(1);
	}

}
