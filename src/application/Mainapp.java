package application;

import java.io.IOException;

//Fx import
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import scene.*;
import shareObject.StageIndex;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
//Fx

public class Mainapp extends Application{
	int sceneNow = -1;
	int nowStage;
	Scene scene;
	AudioClip sound;
	FirstScene firstScene = new FirstScene(1024,640);
	SecondScene secondScene = new SecondScene(1024,640);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		StageIndex.getInstance().setstageIndex(0);
		nowStage = StageIndex.getInstance().getstageIndex();
		// TODO Auto-generated method stub
		StackPane root = new StackPane();
		scene = new Scene(root);
		mainStage.setScene(scene);
		mainStage.setTitle("The jouney of magic card master");
		// to be fix
		root.getChildren().add(firstScene);
		
		mainStage.show();
		AnimationTimer animation = new AnimationTimer() {
			@Override
			public void handle(long now) {
				nowStage = StageIndex.getInstance().getstageIndex();
				switch(nowStage) {
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
