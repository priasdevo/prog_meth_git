package application;

import java.io.IOException;

import gameLogic.GameLogic;
//Fx import
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import logicEntities.base.CardTemplate;
import logicEntities.card.*;
import scene.*;
import shareObject.StageIndex;
import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import shareObject.GameConfig;
import shareObject.GameSaved;
import shareObject.SoundHolder;
//Fx

/**
 * @author Napat
 * The main class for running game
 */
public class Mainapp extends Application{
	/**
	 * Contain the scene that are being render
	 */
	int sceneNow = StageIndex.prepare;
	/**
	 * Contain the scene that should be render now
	 */
	int nowStage;
	/**
	 * The scene that show
	 */
	Scene scene;
	/**
	 * The BGM to play
	 */
	AudioClip sound;
	/**
	 * The object refer to main menu scene
	 */
	FirstScene firstScene = new FirstScene(GameConfig.screenWidth,GameConfig.screenHeight);
	/**
	 * Object refer to battle scene
	 */
	SecondScene secondScene = new SecondScene(GameConfig.screenWidth,GameConfig.screenHeight);
	/**
	 * Object refer to transition scene
	 */
	GameTransitionScene gameTransitionScene = new GameTransitionScene(GameConfig.screenWidth,GameConfig.screenHeight);
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * The main function for JavaFX
	 * Check the name is it null?
	 * Set up the stage and Start animationTimer for each Scene
	 */
	@Override
	public void start(Stage mainStage) throws Exception {
		// --------------------------------------------------------//
		// ---------------------For Test Preference----------------//
		//GameSaved.clear();
		// ------------------------End-----------------------------//
		// --------------------------------------------------------//
		if(GameSaved.getPlayer_name()==null) {StageIndex.getInstance().setstageIndex(-1);}
		else {StageIndex.getInstance().setstageIndex(0);}
		nowStage = StageIndex.getInstance().getstageIndex();

		StackPane root = new StackPane();
		scene = new Scene(root);
		mainStage.setScene(scene);
		mainStage.setTitle("Fantasia");
		// to be fix
		//root.getChildren().add(firstScene);
		mainStage.setResizable(false);
		mainStage.show();
		AnimationTimer animation = new AnimationTimer() {
			@Override
			public void handle(long now) {
				nowStage = StageIndex.getInstance().getstageIndex();
				switch(nowStage) {
					case StageIndex.prepare:
						break;
					case StageIndex.mainMenu:
						firstSceneRender(root,mainStage);
						break;
					case StageIndex.battle:
						secondSceneRender(root,mainStage);
						//testSceneRender(root,mainStage);
						break;
					case StageIndex.Transition :
						gameTransitionRender(root,mainStage);
						break;
				}
				
			}

			
		};
		animation.start();
		// --------------------------------------------------------//
		// ---------------------Check Name-------------------------//
		if(GameSaved.getPlayer_name()==null) {
			Label command = new Label();
			command.setText("Please Input your name\n");
			command.setTextFill(Color.WHITE);
			System.out.println("Noname");
			StackPane inputnamePane = new StackPane();
			inputnamePane.setPrefWidth(GameConfig.screenWidth);
			inputnamePane.setPrefHeight(GameConfig.screenHeight);
			VBox input = new VBox();
			TextField name_input = new TextField();
			Button confirm = new Button();
			confirm.setText("Confirm name");
			input.getChildren().addAll(command,name_input,confirm);
			root.getChildren().add(input);
			input.setAlignment(Pos.CENTER);
			name_input.setMaxWidth(GameConfig.screenWidth/3);
			input.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
			confirm.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					GameSaved.setPlayer_name(name_input.getText());
					root.getChildren().remove(input);
					StageIndex.getInstance().setstageIndex(StageIndex.mainMenu);
				}
				
			});
		}
		// ------------------------End-----------------------------//
		// --------------------------------------------------------//
	}
	/**
	 * Render the Main Menu 
	 * @param root The root Pane
	 * @param mainStage 
	 */
	public void firstSceneRender(StackPane root,Stage mainStage) {
		if(sceneNow != nowStage) {
			root.getChildren().clear();
			try {
		        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FirstScene.fxml"));
		        //sound = new AudioClip(null);
		        sound = SoundHolder.firstSceneBGM;
		        // Classloader , lect05 javafx.jar
		        //sound = new AudioClip(ClassLoader.getSystemResource("BackgroundMusic.wav").toString());
		        sound.setVolume(0.2);
		        sound.play();
				root = loader.load();
				//System.out.println("test");
				scene = new Scene(root);
				mainStage.setScene(scene);
				mainStage.setTitle("Fantasia");
				GameLogic.setRoot(scene.lookup("#rootpane"));
				/*Test*/
				//root.getChildren().add(new CardTemplate());
				//root.getChildren().add(new WhiteStallionOfSun().getCard_ob());
				/*Test*/
				GameLogic.setScene(scene);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			GameLogic.setRoot(scene.lookup("#rootpane"));
			firstScene.addPlayerData();
			sceneNow=nowStage;
		}
		else {
			firstScene.setScreen(scene);
		}
	}
	/**
	 * Render the battle scene
	 * @param root The root Pane
	 * @param mainStage
	 */
	public void secondSceneRender(StackPane root,Stage mainStage) {
		if(sceneNow != nowStage) {
			root.getChildren().clear();
			try {
				sound.stop();
				sound = SoundHolder.battleBGM;
				sound.setVolume(0.1);
				sound.play();
				System.out.println("GameRound : " + GameLogic.getRound());
		        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SecondScene.fxml"));
				root = loader.load();
				//System.out.println("test");
				scene = new Scene(root);
				mainStage.setScene(scene);
				mainStage.setTitle("Fantasia");
				GameLogic.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
			sceneNow = nowStage;
			secondScene.init(scene);
		}else {
			secondScene.setScreen(scene);
		}
	}
	/**
	 * Render the Transition Scene
	 * @param root The Root Pane
	 * @param mainStage
	 */
	public void gameTransitionRender(StackPane root, Stage mainStage) {
		// TODO Auto-generated method stub
		if(sceneNow != nowStage) {
			
			root.getChildren().clear();
			try {
				sound.stop();
				if(GameLogic.getResult()==1) {
					sound = SoundHolder.winningBGM;
					sound.setVolume(0.1);
				}else {
					sound= SoundHolder.losingBGM;
					sound.setVolume(1.0);
				}
				
				
				sound.play();
		        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/WinGameScene.fxml"));
				root = loader.load();
				System.out.println("test");
				scene = new Scene(root);
				mainStage.setScene(scene);
				mainStage.setTitle("Fantasia");
				GameLogic.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
			sceneNow = nowStage;
			gameTransitionScene.init(scene);
		}
	}

}
