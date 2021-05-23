package shareObject;

import javafx.scene.image.Image;

/**
 * @author Napat
 * Contain the image for each card
 */
public class CardImageHolder {
	
	private static final CardImageHolder instance = new CardImageHolder();
	
	public static Image boar_of_destruction;
	public static Image bull_of_power;
	public static Image camel_of_proficient;
	public static Image gale_of_travel;
	public static Image goat_of_thunder;
	public static Image magic_bullet;
	public static Image magic_shield;
	public static Image ram_who_defy_death;
	public static Image raptor_of_wind;
	public static Image sword_of_wisdom;
	public static Image white_stallion_of_sun;
	public static Image youth_of_protection;
	public static Image mana_crystal;
	public static Image card_frame;
	static {
		loadResource();
	}
	public static void loadResource() {
		// CardImage 
		CardImageHolder.boar_of_destruction = new Image(ClassLoader.getSystemResource("cardImage/boar_of_destruction.png").toString());
		CardImageHolder.bull_of_power = new Image(ClassLoader.getSystemResource("cardImage/bull_of_power.png").toString());
		CardImageHolder.camel_of_proficient = new Image(ClassLoader.getSystemResource("cardImage/camel_of_proficient.png").toString());
		CardImageHolder.gale_of_travel = new Image(ClassLoader.getSystemResource("cardImage/gale_of_travel.png").toString());
		CardImageHolder.goat_of_thunder = new Image(ClassLoader.getSystemResource("cardImage/goat_of_thunder.png").toString());
		CardImageHolder.magic_bullet = new Image(ClassLoader.getSystemResource("cardImage/magic_bullet.png").toString());
		CardImageHolder.magic_shield = new Image(ClassLoader.getSystemResource("cardImage/magic_shield.png").toString());
		CardImageHolder.ram_who_defy_death = new Image(ClassLoader.getSystemResource("cardImage/ram_who_defy_death.png").toString());
		CardImageHolder.raptor_of_wind = new Image(ClassLoader.getSystemResource("cardImage/raptor_of_wind.png").toString());
		CardImageHolder.sword_of_wisdom = new Image(ClassLoader.getSystemResource("cardImage/sword_of_wisdom.jpg").toString());
		CardImageHolder.white_stallion_of_sun = new Image(ClassLoader.getSystemResource("cardImage/white_stallion_of_sun.png").toString());
		CardImageHolder.youth_of_protection = new Image(ClassLoader.getSystemResource("cardImage/youth_of_protection.png").toString());
		
		// Card Component
		CardImageHolder.card_frame = new Image(ClassLoader.getSystemResource("cardImage/CardTemplate.png").toString());
		CardImageHolder.mana_crystal = new Image(ClassLoader.getSystemResource("cardImage/Mana_crystal_2.png").toString());
		
	}
	public static CardImageHolder getInstance() {
		return instance;
	}
}
