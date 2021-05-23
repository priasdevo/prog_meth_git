package shareObject;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

/**
 * @author Napat
 * Contain Game music
 */
public class SoundHolder {
	public static AudioClip  firstSceneBGM;
	public static AudioClip  battleBGM;
	public static AudioClip  winningBGM;
	public static AudioClip  losingBGM;
	static {
		loadResource();
	}
	public static void loadResource() {
		firstSceneBGM =  new AudioClip(ClassLoader.getSystemResource("music/BackgroundMusic.wav").toString());
		battleBGM =  new AudioClip(ClassLoader.getSystemResource("music/BattleBGM.mp3").toString());
		winningBGM =  new AudioClip(ClassLoader.getSystemResource("music/WinBGM.mp3").toString());
		losingBGM =  new AudioClip(ClassLoader.getSystemResource("music/LoseBGM.mp3").toString());
		}
}
