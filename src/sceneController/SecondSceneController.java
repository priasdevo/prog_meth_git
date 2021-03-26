package sceneController;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import shareObject.SecondSceneObjectHolder;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
public class SecondSceneController {
	@FXML
	Canvas SecondSceneBackground;
	@FXML
	GridPane grid;

	public void initialize() {
		// TODO Auto-generated method stub
		//firstBackgroundCanvas = new Canvas(640,480);
		System.out.println("Controller bind successfully GIT");
		grid.setOnDragOver(e -> {
			//if (e.getGestureSource() != grid && e.getDragboard().hasString()) {

			//e.acceptTransferModes(TransferMode.MOVE);
			//}
            e.acceptTransferModes(TransferMode.MOVE);
            SecondSceneObjectHolder.getInstance().setCurrentX(e.getX());
            SecondSceneObjectHolder.getInstance().setCurrentY(e.getY());
            SecondSceneObjectHolder.getInstance().setIsDragging(true);
            System.out.print(e.getX()+" ");
            System.out.println(e.getY());
            e.consume();
	    });
		grid.setOnDragDropped(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event) {
				System.out.println("onDragDropped");
				//event.setDropCompleted(success);
				event.consume();
			}
		});
		/*grid.setOnDragOver(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event) {

				System.out.println("onDragOver");


				if (event.getGestureSource() != grid && event.getDragboard().hasString()) {

					event.acceptTransferModes(TransferMode.MOVE);
				}

				event.consume();
			}
		});*/

		
	}
	
}
