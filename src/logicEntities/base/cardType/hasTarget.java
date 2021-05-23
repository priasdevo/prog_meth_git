package logicEntities.base.cardType;

import logicEntities.base.Monster;

/**
 * @author Napat
 * Indicate that this card need target
 */
public interface hasTarget {
	public void setTarget(Monster monster);
}
