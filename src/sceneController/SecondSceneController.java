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
import logicEntities.base.cardType.hasTarget;
import shareObject.MousePositionPointer;
import gameLogic.BuffManager;
import gameLogic.CardManager;
import gameLogic.GameLogic;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
/**
 * @author Napat
 * Init basic property for battle scene
 */
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
	/**
	 * Initialize battle scene
	 */
	public void initialize() {
		//System.out.println("Controller bind successfully GIT");
		grid.setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.MOVE);
            MousePositionPointer.getInstance().setCurrentX(e.getX());
            MousePositionPointer.getInstance().setCurrentY(e.getY());
            MousePositionPointer.getInstance().setIsDragging(true);
            //System.out.print(SecondSceneObjectHolder.getInstance().getCardX());
            //System.out.print("   "+SecondSceneObjectHolder.getInstance().getCardY()+"\n");
            e.consume();
	    });
		grid.setOnDragDropped(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event) {
				if(!(CardManager.getCurrentCard() instanceof hasTarget)) {
					GameLogic.addAction(null);
				}
				System.out.println("onDragDropped");
				event.consume();
			}
		});
		GameLogic.setEndTurnButton(endTurnButton);
		
	}
	/**
	 * Endturn Action
	 */
	public void endTurn() {
		GameLogic.setTurnPass(GameLogic.getTurnPass()+1);
	//System.out.println("Endturn");
		endTurnButton.setDisable(true);
		BuffManager.endTurnChange();
		BuffManager.updateBuff();
		GameLogic.endTurn();
	}
}
