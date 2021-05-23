package gameLogic.action;

import gameLogic.BuffManager;
import logicEntities.base.Card;

/**
 * @author Napat
 * The action that indicate some card are being used
 */
public class CardUseAction extends ActionBase{
	public Card usedCard;
	public CardUseAction(String targetType,Card usedCard) {
		super(targetType);
		this.usedCard = usedCard;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Activate() {
		// TODO Auto-generated method stub
		BuffManager.cardUseBuffActivate(usedCard);
	}

}
