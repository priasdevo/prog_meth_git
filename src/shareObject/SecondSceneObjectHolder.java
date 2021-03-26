package shareObject;

import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class SecondSceneObjectHolder {
	private static final SecondSceneObjectHolder instance = new SecondSceneObjectHolder();

	private List<Renderable> toRenderObject;
	private Comparator<Renderable> comparator;
	public static Image fisrtSceneBackgroundImage;
	public static AudioClip  firstSceneBGM;
	private double currentX;
	private double currentY;
	private boolean isDragging;
	
	public boolean getIsDragging() {
		return isDragging;
	}
	public void setIsDragging(boolean isDragging) {
		this.isDragging = isDragging;
	}
	public List<Renderable> gettoRenderObject() {
		return toRenderObject;
	}
	public static SecondSceneObjectHolder getInstance() {
		return instance;
	}
	public double getCurrentX() {
		return currentX;
	}
	public void setCurrentX(double currentX) {
		this.currentX = currentX;
	}
	public double getCurrentY() {
		return currentY;
	}
	public void setCurrentY(double currentY) {
		this.currentY = currentY;
	}
	
}
