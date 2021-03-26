package shareObject;

import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class FirstSceneObjectHolder {
	
	private static final FirstSceneObjectHolder instance = new FirstSceneObjectHolder();

	private List<Renderable> toRenderObject;
	private Comparator<Renderable> comparator;
	public static Image fisrtSceneBackgroundImage;
	public static AudioClip  firstSceneBGM;
	static {
		loadResource();
	}
	public static void loadResource() {
		fisrtSceneBackgroundImage = new Image(ClassLoader.getSystemResource("firstScene/images/Background.jpg").toString());
		//explosionSound = new AudioClip(ClassLoader.getSystemResource("Explosion.wav").toString());
	}
	public List<Renderable> gettoRenderObject() {
		return toRenderObject;
	}
	public static FirstSceneObjectHolder getInstance() {
		return instance;
	}

}
