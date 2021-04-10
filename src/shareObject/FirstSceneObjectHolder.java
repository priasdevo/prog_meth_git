package shareObject;

import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class FirstSceneObjectHolder {
	
	private static final FirstSceneObjectHolder instance = new FirstSceneObjectHolder();


	public static Image fisrtSceneBackgroundImage;
	public static AudioClip  firstSceneBGM;
	static {
		loadResource();
	}
	public static void loadResource() {
		fisrtSceneBackgroundImage = new Image(ClassLoader.getSystemResource("firstScene/images/Background.jpg").toString());
		//explosionSound = new AudioClip(ClassLoader.getSystemResource("Explosion.wav").toString());
	}

	public static FirstSceneObjectHolder getInstance() {
		return instance;
	}

}
