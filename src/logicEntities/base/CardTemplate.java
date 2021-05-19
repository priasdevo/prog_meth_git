package logicEntities.base;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import shareObject.FirstSceneObjectHolder;

public class CardTemplate extends Canvas{

	public CardTemplate() {
		super(143, 215);
		GraphicsContext gc = this.getGraphicsContext2D();
		WritableImage croppedImage = new WritableImage(new Image(ClassLoader.getSystemResource("secondScene/images/CardTemplate.png").toString()).getPixelReader(),
				0, 0, 128, 200);
		gc.drawImage(croppedImage, 15, 15);
	
		//Test
		Image manaCrystal = new Image(ClassLoader.getSystemResource("secondScene/Images/Mana_crystal_2.png").toString());
		//manaCrystal = scale(manaCrystal,30,30,false);
		gc.drawImage(manaCrystal, 5, 5);
		Image getImage = new Image(ClassLoader.getSystemResource("secondScene/images/magic_bullet.png").toString());
		Image newImage = scale(getImage,103,60,false);
		this.setImage(new WritableImage(newImage.getPixelReader(),
				0, 0, 103, 59));
		this.setName("TEST");
		this.setText("Test\nTest\nTest");
		this.setText("ADD TEST");
		this.setManaCost(5);
		// TODO Auto-generated constructor stub
	}
	public void setImage(WritableImage Image) {
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.drawImage(Image, 30, 58,103,60);
	}
	public void setManaCost(int cost) {
		GraphicsContext gc = this.getGraphicsContext2D();
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.fillText(Integer.toString(cost), 19, 20);
	}
	public void setName(String name) {
		GraphicsContext gc = this.getGraphicsContext2D();
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.fillText(
            name, 
            81, 
            40,
            103
        );

	}
	public void setText(String description) {
		GraphicsContext gc = this.getGraphicsContext2D();
		WritableImage croppedImage = new WritableImage(new Image(ClassLoader.getSystemResource("secondScene/images/CardTemplate.png").toString()).getPixelReader(),
				26, 117, 80, 60);
		gc.drawImage(croppedImage, 41, 132);
		
		gc.setFont(new Font("Aria", 12));
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.TOP);
        gc.fillText(
        	description, 
            81, 
            132,
            80
        );
	}
	public Image scale(Image source, int targetWidth, int targetHeight, boolean preserveRatio) {
	    ImageView imageView = new ImageView(source);
	    imageView.setPreserveRatio(preserveRatio);
	    imageView.setFitWidth(targetWidth);
	    imageView.setFitHeight(targetHeight);
	    return imageView.snapshot(null, null);
	}
}
