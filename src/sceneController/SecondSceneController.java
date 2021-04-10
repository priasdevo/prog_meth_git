package sceneController;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import shareObject.SecondSceneObjectHolder;
import gameLogic.GameLogic;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
public class SecondSceneController {
	@FXML
	Canvas SecondSceneBackground;
	@FXML
	GridPane grid;
	@FXML
	HBox cardBox;
	@FXML
	Button endTurnButton;
	@FXML
	HBox statBar;
	public void initialize() {
		System.out.println("Controller bind successfully GIT");
		grid.setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.MOVE);
            SecondSceneObjectHolder.getInstance().setCurrentX(e.getX());
            SecondSceneObjectHolder.getInstance().setCurrentY(e.getY());
            SecondSceneObjectHolder.getInstance().setIsDragging(true);
            System.out.print(SecondSceneObjectHolder.getInstance().getCardX());
            System.out.print("   "+SecondSceneObjectHolder.getInstance().getCardY()+"\n");
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
		GameLogic.setEndTurnButton(endTurnButton);
		statBar.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	public void endTurn() {
	System.out.println("Endturn");
		endTurnButton.setDisable(true);
		GameLogic.endTurn();
	}
}
