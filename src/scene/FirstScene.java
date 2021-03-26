package scene;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import shareObject.FirstSceneObjectHolder;

public class FirstScene extends Canvas{
	double backgroundMovingX = -3,backgroundMovingBack =0.015;
	
	public FirstScene(double width,double height) {
		super(width,height);
		this.setVisible(true);
		addListener();
	}
	public void addListener() {
		
	}
	public void setScreen(Scene scene) {
		Canvas canvas = (Canvas) scene.lookup("#firstCanvas");
		//Button testbutt = (Button) scene.lookup("#StartButt");
		//testbutt.getText();
		GraphicsContext gc = canvas.getGraphicsContext2D();
		backgroundMovingX += backgroundMovingBack;
		//System.out.println(backgroundMovingX);
		if(backgroundMovingX >= 0 || backgroundMovingX <= -6) {
			backgroundMovingBack=-backgroundMovingBack;
		}
		WritableImage croppedImage = new WritableImage(FirstSceneObjectHolder.fisrtSceneBackgroundImage.getPixelReader(),
				270, 90, 1024, 640);
		gc.drawImage(croppedImage, backgroundMovingX, 0);
	}
}