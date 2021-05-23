package logicEntities.card;

import gameLogic.CardManager;
import gameLogic.GameLogic;
import gameLogic.action.AttackAction;
import gameLogic.action.CardUseAction;
import javafx.scene.image.Image;
import logicEntities.Player;
import logicEntities.base.Card;
import logicEntities.base.Monster;
import logicEntities.base.cardType.hasTarget;
import shareObject.CardImageHolder;

/**
 * @author Napat
 * Magic bullet card
 */
public class MagicBullet extends Card implements hasTarget{
	private Monster target;
	private final int attack_power = 5;
	public MagicBullet() {
		super(1, "Magic Bullet", "deal 5 damage to \ntarget enemy");
		/*this.card_ob = new ImageView();
		this.card_ob.setImage(new Image(ClassLoader.getSystemResource("secondScene/images/fireball_blank.png").toString()));
		this.card_ob.setFitHeight(cardHeight);
		this.card_ob.setFitWidth(cardWidth);*/
		this.card_ob.setImage(CardImageHolder.magic_bullet);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void use() {
		if(Player.getInstance().getMana()>=this.manacost) {
			GameLogic.getActionManager().add(new CardUseAction("None",this));
			GameLogic.getActionManager().add( new AttackAction("Single",target.getMonster_id(),attack_power) );
			CardManager.disCard(this);
			Player.getInstance().setMana(Player.getInstance().getMana()-this.manacost);
			Player.getInstance().updateMana();
		}
		
	}
	@Override
	public void setTarget(Monster monster) {
		this.target = monster;
		// TODO Auto-generated method stub
	}
}