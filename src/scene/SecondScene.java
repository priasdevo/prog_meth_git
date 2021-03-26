package scene;

import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import shareObject.FirstSceneObjectHolder;
import shareObject.SecondSceneObjectHolder;


public class SecondScene extends Canvas{
	
	public SecondScene(double width,double height) {
		super(width,height);
		this.setVisible(true);
		addListener();
	}
	public void init(Scene scene) {
		GridPane grid = (GridPane) scene.lookup("#grid");
		ImageView card1 = new ImageView();
		card1.setImage(new Image(ClassLoader.getSystemResource("secondScene/images/fireball_blank.png").toString()));
		card1.setFitHeight(200);
		card1.setFitWidth(125);
		grid.add(card1,7,12);
		card1.setOnDragDetected(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				Dragboard db = card1.startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content = new ClipboardContent();
				content.putString(card1.getImage().toString());
				db.setContent(content);
				System.out.print("Test");
			}
		});
		card1.setOnDragDone(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent arg0) {
				SecondSceneObjectHolder.getInstance().setIsDragging(false);
			}
		});

	}
	public void addListener() {
		
	}
	public void setScreen(Scene scene) {
		Canvas canvas = (Canvas) scene.lookup("#SecondSceneBackground");
		GraphicsContext gc = canvas.getGraphicsContext2D();
		//gc.setFill(Color.BLACK);
		WritableImage croppedImage = new WritableImage(FirstSceneObjectHolder.fisrtSceneBackgroundImage.getPixelReader(),
				270, 90, 1024, 640);
		gc.drawImage(croppedImage, 0, 0);
		if(SecondSceneObjectHolder.getInstance().getIsDragging()) {
			gc.beginPath();
			gc.moveTo(396, 478);
			gc.quadraticCurveTo(346, 438, SecondSceneObjectHolder.getInstance().getCurrentX(), SecondSceneObjectHolder.getInstance().getCurrentY());
			//gc.lineTo((396+SecondSceneObjectHolder.getInstance().getCurrentX())/2, (478+SecondSceneObjectHolder.getInstance().getCurrentY())/2);
			//gc.lineTo(SecondSceneObjectHolder.getInstance().getCurrentX(), SecondSceneObjectHolder.getInstance().getCurrentY());
			//gc.closePath();
			gc.stroke();
			
		}
		
	}
}
