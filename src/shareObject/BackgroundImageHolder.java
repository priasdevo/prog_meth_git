package shareObject;

import javafx.scene.image.Image;

/**
 * @author Napat
 * Contain the background Image
 */
public class BackgroundImageHolder {
	public static Image fisrtSceneBackgroundImage;
	public static Image textBackground;
	public static Image battleBackground;
	public static Image transitionBackground;
	static {
		loadResource();
	}
	public static void loadResource() {
		fisrtSceneBackgroundImage = new Image(ClassLoader.getSystemResource("backGround/Background.jpg").toString());
		textBackground = new Image(ClassLoader.getSystemResource("backGround/TextBackground.jpg").toString());
		battleBackground = new Image(ClassLoader.getSystemResource("backGround/BattleBackground.jpg").toString());
		transitionBackground = new Image(ClassLoader.getSystemResource("backGround/TransitionBackground.jpg").toString());
		//explosionSound = new AudioClip(ClassLoader.getSystemResource("Explosion.wav").toString());
	}
}
