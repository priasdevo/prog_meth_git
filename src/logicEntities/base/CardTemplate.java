package logicEntities.base;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javafx.geometry.VPos;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import shareObject.CardImageHolder;
import shareObject.GameConfig;

/**
 * @author Napat
 * The Image of card in canvas
 */
public class CardTemplate extends Canvas{
	private final int startPoint = 0;
	private final int cardFrameHeight = 200;
	private final int cardFrameWidth = 128;
	private final int cardFrameXStart = 15;
	private final int cardFrameYStart = 15;
	private final int manaCrystalXStart = 5;
	private final int manaCrystalYStart = 5;
	private final int cardImageWidth = 103;
	private final int cardImageHeight = 60;
	private final int cardImageXStart = 29;
	private final int cardImageYStart = 58;
	private final int manaCostXStart = 19;
	private final int manaCostYStart = 20;
	private final int nameXStart = 81;
	private final int nameYStart = 40;
	private final int nameWidth = 103;
	private final int descriptionBoxXStart = 26;
	private final int descriptionBoxYStart = 117;
	private final int descriptionBoxWidth = 80;
	private final int descriptionBoxHeight = 60;
	private final int descriptionBoxXStart2 = 41;
	private final int descriptionBoxYStart2 = 132;
	private final int descriptionTextXStart = 81;
	private final int descriptionTextYStart = 134;
	private final int descriptionTextSize = 8;
	
	
	public CardTemplate() {
		super(GameConfig.cardWidth, GameConfig.cardHeight);
		GraphicsContext gc = this.getGraphicsContext2D();
		WritableImage croppedImage = new WritableImage(CardImageHolder.card_frame.getPixelReader(),
				this.startPoint, this.startPoint, this.cardFrameWidth, this.cardFrameHeight);
		gc.drawImage(croppedImage, this.cardFrameXStart, this.cardFrameYStart);
	
		//Test
		Image manaCrystal = CardImageHolder.mana_crystal;
		//manaCrystal = scale(manaCrystal,30,30,false);
		gc.drawImage(manaCrystal, this.manaCrystalXStart, this.manaCrystalYStart);
	}
	
	/**
	 * render the card Image 
	 * @param source the image
	 */
	public void setImage(Image source) {
		GraphicsContext gc = this.getGraphicsContext2D();
		source = scale(source,this.cardImageWidth,this.cardImageHeight,false);
		WritableImage Image = new WritableImage(source.getPixelReader(),
				this.startPoint, this.startPoint, this.cardImageWidth, cardImageHeight-1);
		gc.drawImage(Image, this.cardImageXStart, this.cardImageYStart,this.cardImageWidth+1,cardImageHeight);
	}
	
	/**
	 * Render the mana cost
	 * @param cost the mana cost
	 */
	public void setManaCost(int cost) {
		GraphicsContext gc = this.getGraphicsContext2D();
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.fillText(Integer.toString(cost), this.manaCostXStart, this.manaCostYStart);
	}
	
	/**
	 * Render card name
	 * @param name
	 */
	public void setName(String name) {
		GraphicsContext gc = this.getGraphicsContext2D();
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.fillText(
            name, 
            this.nameXStart, 
            this.nameYStart,
            this.nameWidth
        );

	}
	
	/**
	 * render card description
	 * @param description
	 */
	public void setText(String description) {
		GraphicsContext gc = this.getGraphicsContext2D();
		WritableImage croppedImage = new WritableImage(CardImageHolder.card_frame.getPixelReader(),
				this.descriptionBoxXStart, this.descriptionBoxYStart, this.descriptionBoxWidth, this.descriptionBoxHeight);
		gc.drawImage(croppedImage, this.descriptionBoxXStart2, this.descriptionBoxYStart2);
		
		gc.setFont(new Font("Aria", this.descriptionTextSize));
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.TOP);
        gc.fillText(
        	description, 
            this.descriptionTextXStart, 
            this.descriptionTextYStart,
            this.descriptionBoxWidth
        );
	}
	
	/**
	 * Just resize Image
	 * @param source
	 * @param targetWidth
	 * @param targetHeight
	 * @param preserveRatio
	 * @return
	 */
	public Image scale(Image source, int targetWidth, int targetHeight, boolean preserveRatio) {
	    ImageView imageView = new ImageView(source);
	    imageView.setPreserveRatio(preserveRatio);
	    imageView.setFitWidth(targetWidth);
	    imageView.setFitHeight(targetHeight);
	    SnapshotParameters parameters = new SnapshotParameters();
		parameters.setFill(Color.TRANSPARENT);
	    return imageView.snapshot(parameters, null);
	}
}
