package gameLogic.statusEffect.specificStatusEffect.cardUseApplay;

import gameLogic.statusEffect.CardUseApplyStatusEffect;
import gameLogic.statusEffect.StatusEffectBase;
import javafx.application.Platform;
import logicEntities.base.Card;

/**
 * @author Napat
 * Re use the next card that will be used
 */
public class WindOfRaptor extends StatusEffectBase implements CardUseApplyStatusEffect{

	public WindOfRaptor() {
		super(statusType,"Wind of Raptor");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Activate(Card cardUsed) {
		// TODO Auto-generated method stub
		if(this.getStack()>0) {
			Platform.runLater(()->{
				cardUsed.use();
			});
		}
		
		
		this.setStack(this.getStack()-1);
	}

	@Override
	public void endTurnChange() {
		// TODO Auto-generated method stub
	}

}
