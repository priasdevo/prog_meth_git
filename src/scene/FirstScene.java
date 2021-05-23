package scene;

import gameLogic.GameLogic;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import shareObject.BackgroundImageHolder;
import shareObject.GameConfig;
import shareObject.GameSaved;

/**
 * @author Napat
 * The BackEnd for MainMenu
 * Init the properties need in MainMenu and make BackgroundMove a little
 */
public class FirstScene extends Canvas{
	
	/**
	 * Speed of Background Moving
	 */
	private double backgroundMovingSpeed = 0.015;
	/**
	 * The position of moving background
	 */
	private double backgroundMovingX = -3;
	/**
	 * the lower limit of moving background
	 */
	private final int minimumBackgroudPos = -6;
	/**
	 * the upper limit of moving background
	 */
	private final int maximumBackgroudPos = 0;
	private final int startPoint = 0;
	private final int startCropX = 270;
	private final int startCropY = 90;
	
	/**
	 * @param width The width of the scene
	 * @param height The Height of the scene
	 */
	public FirstScene(double width,double height) {
		super(width,height);
		this.setVisible(true);
	}
	/**
	 * Construct the player Info such as name,level
	 */
	public void addPlayerData() {
		StackPane root = (StackPane) GameLogic.getRoot();
		//VBox info = new VBox();
		//info.setAlignment(Pos.TOP_LEFT);
		Label playerInfo = new Label();
		playerInfo.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		//playerInfo.setGraphic(new ImageView(BackgroundImageHolder.textBackground));
		playerInfo.setText(" Player :"+GameSaved.getPlayer_name()+"\n Level : "+GameSaved.getPlayer_level()+"\n Experience point : "+GameSaved.getExperiencePoint()+"/"+GameSaved.getExperiencePoint_Max()+"   ");
		//playerInfo.setAlignment(Pos.TOP_LEFT);
		//info.getChildren().add(playerInfo);
		root.getChildren().add(playerInfo);
		StackPane.setAlignment(playerInfo,Pos.TOP_LEFT);
	}
	/**
	 * Update the Changed scene on each second
	 * @param scene The scene that are showing
	 */
	public void setScreen(Scene scene) {
		Canvas canvas = (Canvas) scene.lookup("#firstCanvas");
		//Button testbutt = (Button) scene.lookup("#StartButt");
		//testbutt.getText();
		GraphicsContext gc = canvas.getGraphicsContext2D();
		backgroundMovingX += backgroundMovingSpeed;
		//System.out.println(backgroundMovingX);
		if(backgroundMovingX >= maximumBackgroudPos || backgroundMovingX <= minimumBackgroudPos) {
			backgroundMovingSpeed=-backgroundMovingSpeed;
		}
		WritableImage croppedImage = new WritableImage(BackgroundImageHolder.fisrtSceneBackgroundImage.getPixelReader(),
				startCropX, startCropY, GameConfig.screenWidth, GameConfig.screenHeight);
		gc.drawImage(croppedImage, backgroundMovingX, startPoint);
	}
}
