package sceneController;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import application.Mainapp;
import shareObject.StageIndex;
import shareObject.SecondSceneObjectHolder;
public class SecondSceneController {
	@FXML
	Canvas SecondSceneBackground;
	@FXML
	ImageView Card1; 
	@FXML
	GridPane grid;

	public void initialize() {
		// TODO Auto-generated method stub
		//firstBackgroundCanvas = new Canvas(640,480);
		System.out.println("Controller bind successfully 2");
		grid.setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.COPY);
            SecondSceneObjectHolder.getInstance().setCurrentX(e.getX());
            SecondSceneObjectHolder.getInstance().setCurrentY(e.getY());
            SecondSceneObjectHolder.getInstance().setIsDragging(true);
            System.out.print(e.getX()+" ");
            System.out.println(e.getY());
	    });

	}
	
}
