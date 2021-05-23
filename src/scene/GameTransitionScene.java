package scene;

import gameLogic.BuffManager;
import gameLogic.GameLogic;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import logicEntities.Player;
import shareObject.BackgroundImageHolder;
import shareObject.GameConfig;
import shareObject.GameSaved;
import shareObject.StageIndex;

/**
 * @author Napat
 * The transition scene after end of each battle round
 */
public class GameTransitionScene extends Canvas{

	public GameTransitionScene(int screenwidth, int screenheight) {
		// TODO Auto-generated constructor stub
		super(screenwidth,screenheight);
		this.setVisible(true);
	}
	/**
	 * init the scene
	 * @param scene The scene
	 */
	public void init(Scene scene) {
		Canvas canvas = (Canvas) scene.lookup("#TransitionCanvas");
		GraphicsContext gc = canvas.getGraphicsContext2D();
		//gc.setFill(Color.BLACK);
		WritableImage croppedImage = new WritableImage(BackgroundImageHolder.transitionBackground.getPixelReader(),
				0, 0, GameConfig.screenWidth, GameConfig.screenHeight);
		gc.setGlobalAlpha(0.3);
		gc.drawImage(croppedImage, 0, 0);
		//canvas.setTrans
		Player.getInstance().setMana(Player.getInstance().getMana_max());
		GameLogic.setTurnPass(0);
		GameLogic.setRoot(scene.lookup("#rootPane"));
		Label winloseText = new Label();
		
		BuffManager.clear();
		
		if(GameLogic.getResult()==0) {
			winloseText.setText("Defeated");
		}else {
			winloseText.setText("You win");
			switch(GameLogic.getRound()) {
			case 1:
				GameSaved.gainExperience(GameConfig.round1XP);
				break;
			case 2:
				GameSaved.gainExperience(GameConfig.round2XP);
				break;
			case 3:
				GameSaved.gainExperience(GameConfig.round3XP);
				break;
			case 4:
				GameSaved.gainExperience(GameConfig.round4XP);
				break;
			case 5:
				GameSaved.gainExperience(GameConfig.round5XP);
				break;
			}
		}
		
		StackPane root = (StackPane) GameLogic.getRoot();
		VBox showResult = new VBox();
		HBox navigateButton = new HBox();
		Button returnButton = new Button("Return");
		showResult.setAlignment(Pos.CENTER);
		navigateButton.setAlignment(Pos.CENTER);
		
		returnButton.setOnAction((event)->{
			StageIndex.getInstance().setstageIndex(StageIndex.mainMenu);
			Player.getInstance().setHp(Player.getInstance().getHp_max());
			GameLogic.setRound(0);
		});
		
		showResult.getChildren().add(winloseText);
		navigateButton.getChildren().add(returnButton);
		
		if(GameLogic.getResult()==GameConfig.winResult && !(GameLogic.getRound()==GameConfig.lastRound) ) {
			Label experienceGain = new Label();
			experienceGain.setText("Your Level is "+GameSaved.getPlayer_level()+"\nYour Current EXP = "+GameSaved.getExperiencePoint()+"/"+GameSaved.getExperiencePoint_Max());
			experienceGain.setAlignment(Pos.CENTER);
			Button continueButton = new Button("Continue");
			
			continueButton.setOnAction((event)->{
				StageIndex.getInstance().setstageIndex(StageIndex.battle);
			});
			
			navigateButton.getChildren().add(continueButton);
			showResult.getChildren().add(experienceGain);
		}
		
		showResult.getChildren().addAll(navigateButton);
		root.getChildren().add(showResult);
	}
}
