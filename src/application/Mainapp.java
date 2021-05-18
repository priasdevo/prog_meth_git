package application;

import java.io.IOException;

import gameLogic.GameLogic;
//Fx import
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import scene.*;
import shareObject.StageIndex;
import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
//Fx

public class Mainapp extends Application{
	int sceneNow = -1;
	int nowStage;
	Scene scene;
	AudioClip sound;
	FirstScene firstScene = new FirstScene(GameConfig.screenWidth,GameConfig.screenHeight);
	SecondScene secondScene = new SecondScene(GameConfig.screenWidth,GameConfig.screenHeight);
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		// --------------------------------------------------------//
		// ---------------------For Test Preference----------------//
		GameSaved.clear();
		// ------------------------End-----------------------------//
		// --------------------------------------------------------//
		if(GameSaved.getPlayer_name()==null) {StageIndex.getInstance().setstageIndex(-1);}
		else {StageIndex.getInstance().setstageIndex(0);}
		nowStage = StageIndex.getInstance().getstageIndex();

		StackPane root = new StackPane();
		scene = new Scene(root);
		mainStage.setScene(scene);
		mainStage.setTitle("The jouney of magic card master");
		// to be fix
		//root.getChildren().add(firstScene);
		mainStage.setResizable(false);
		mainStage.show();
		AnimationTimer animation = new AnimationTimer() {
			@Override
			public void handle(long now) {
				nowStage = StageIndex.getInstance().getstageIndex();
				switch(nowStage) {
					case -1:
						break;
					case 0:
						firstSceneRender(root,mainStage);
						break;
					case 1:
						secondSceneRender(root,mainStage);
						//testSceneRender(root,mainStage);
						break;
				}
				
			}
		};
		animation.start();
		// --------------------------------------------------------//
		// ---------------------Check Name-------------------------//
		if(GameSaved.getPlayer_name()==null) {
			System.out.println("Noname");
			StackPane inputnamePane = new StackPane();
			inputnamePane.setPrefWidth(GameConfig.screenWidth);
			inputnamePane.setPrefHeight(GameConfig.screenHeight);
			VBox input = new VBox();
			TextField name_input = new TextField();
			Button confirm = new Button();
			confirm.setText("Confirm name");
			input.getChildren().addAll(name_input,confirm);
			root.getChildren().add(input);
			input.setAlignment(Pos.CENTER);
			name_input.setMaxWidth(GameConfig.screenWidth/3);
			input.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
			confirm.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					GameSaved.setPlayer_name(name_input.getText());
					root.getChildren().remove(input);
					StageIndex.getInstance().setstageIndex(0);
				}
				
			});
		}
		// ------------------------End-----------------------------//
		// --------------------------------------------------------//
	}
	public void firstSceneRender(StackPane root,Stage mainStage) {
		if(sceneNow != nowStage) {
			root.getChildren().clear();
			try {
		        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FirstScene.fxml"));
		        //sound = new AudioClip(null);
		        sound = new AudioClip(ClassLoader.getSystemResource("firstScene.musics/BackgroundMusic.wav").toString());
		        // Classloader , lect05 javafx.jar
		        //sound = new AudioClip(ClassLoader.getSystemResource("BackgroundMusic.wav").toString());
		        sound.play();
				root = loader.load();
				System.out.println("test");
				scene = new Scene(root);
				mainStage.setScene(scene);
				mainStage.setTitle("The jouney of magic card master");
				GameLogic.setScene(scene);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			sceneNow=nowStage;
		}
		else {
			firstScene.setScreen(scene);
		}
	}
	public void secondSceneRender(StackPane root,Stage mainStage) {
		if(sceneNow != nowStage) {
			root.getChildren().clear();
			try {
		        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SecondScene.fxml"));
				root = loader.load();
				System.out.println("test");
				scene = new Scene(root);
				mainStage.setScene(scene);
				mainStage.setTitle("GITTEST");
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

}
