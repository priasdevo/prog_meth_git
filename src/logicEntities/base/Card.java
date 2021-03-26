package logicEntities.base;

public class Card {
	protected int manacost;
	protected String name;
	protected String description;
	
	
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
	
	
}
