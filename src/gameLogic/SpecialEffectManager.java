package gameLogic;

import java.util.ArrayList;

import gameLogic.statusEffect.StatusEffectBase;

public class SpecialEffectManager {
	private ArrayList<StatusEffectBase> specialEffectList;

	public SpecialEffectManager() {
		super();
		this.specialEffectList = new ArrayList<StatusEffectBase>();
	}

	public ArrayList<StatusEffectBase> getSpecialEffectList() {
		return specialEffectList;
	}

	public void setSpecialEffectList(ArrayList<StatusEffectBase> specialEffectList) {
		this.specialEffectList = specialEffectList;
	}
	

}
