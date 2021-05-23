package logicEntities.base;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import shareObject.GameConfig;
/**
 * @author Napat
 * The base class of all card
 */
public class Card {
	protected int manacost;
	protected String name;
	protected String description;
	protected CardTemplate card_ob;
	protected final int cardWidth = GameConfig.cardWidth;
	protected final int cardHeight = GameConfig.cardHeight;
	
	public Card(int manacost, String name, String description) {
		super();
		this.card_ob = new CardTemplate();
		this.manacost = manacost;
		this.name = name;
		this.description = description;
		this.card_ob.setManaCost(manacost);
		this.card_ob.setName(name);
		this.card_ob.setText(description);
	}
	/**
	 * Indicate that all card can be use
	 */
	public void use() {
		
	}
	/**
	 * @return card Image
	 */
	public WritableImage getImage() {
		SnapshotParameters parameters = new SnapshotParameters();
		parameters.setFill(Color.TRANSPARENT);
		return this.card_ob.snapshot(parameters, null);
	}
	public int getManacost() {
		return manacost;
	}
	public void setManacost(int manacost) {
		this.manacost = manacost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCardWidth() {
		return cardWidth;
	}
	public int getCardHeight() {
		return cardHeight;
	}
	public CardTemplate getCard_ob() {
		return card_ob;
	}
	public void setCard_ob(CardTemplate card_ob) {
		this.card_ob = card_ob;
	}
	
	
}
