package shareObject;

import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

/**
 * @author Napat
 * Manage the mouse Postion for arrow pointer
 */
public class MousePositionPointer {
	private static final MousePositionPointer instance = new MousePositionPointer();


	public static Image fisrtSceneBackgroundImage;
	public static AudioClip  firstSceneBGM;
	private double currentX;
	private double currentY;
	private double cardX;
	private double cardY;
	private boolean isDragging;
	
	public boolean getIsDragging() {
		return isDragging;
	}
	public void setIsDragging(boolean isDragging) {
		this.isDragging = isDragging;
	}

	public static MousePositionPointer getInstance() {
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
	public double getCardX() {
		return cardX;
	}
	public void setCardX(double cardX) {
		this.cardX = cardX;
	}
	public double getCardY() {
		return cardY;
	}
	public void setCardY(double cardY) {
		this.cardY = cardY;
	}
	
}
