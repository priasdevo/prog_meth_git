package logicEntities.base;
import javafx.scene.image.ImageView;
import shareObject.GameConfig;
public class Card {
	protected int manacost;
	protected String name;
	protected String description;
	protected ImageView card_ob;
	protected final int cardWidth = GameConfig.cardWidth;
	protected final int cardHeight = GameConfig.cardHeight;
	
	public Card(int manacost, String name, String description) {
		super();
		this.manacost = manacost;
		this.name = name;
		this.description = description;
	}
	public void use() {
		
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
	public ImageView getCard_ob() {
		return card_ob;
	}
	public void setCard_ob(ImageView card_ob) {
		this.card_ob = card_ob;
	}
	
	
}
