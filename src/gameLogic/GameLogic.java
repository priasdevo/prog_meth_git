package gameLogic;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import gameLogic.action.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import logicEntities.base.Monster;
import logicEntities.base.cardType.hasTarget;
public class GameLogic {
		private static ActionManager actionManager;
		private static MonsterManager monsterManager;
		private static CardManager cardManager;
		private static GridPane grid;
		private static HBox cardBox;
		private static Scene scene;
		private static Node root;
		private static Button endTurnButton;
		public static void init() {
			GameLogic.actionManager = new ActionManager();
			GameLogic.monsterManager = new MonsterManager();
			GameLogic.cardManager = new CardManager();
		}
		public static void runAction() {
			for(ActionBase action: GameLogic.actionManager.getActionList()) {
				if(action instanceof AttackAction) {
					ActionHandler.attackTarget(((AttackAction) action).getDamage(), action.getTargetId());
				}
				
			}
			GameLogic.getActionManager().clear();
			try {
				GameLogic.getMonsterManager().clearMonster();
			}
			catch(ConcurrentModificationException e){
				
			}
			
		}
		public static void addAction(Monster monster) {
			GameLogic.getCardManager();
			if(CardManager.getCurrentCard() instanceof hasTarget) {
				((hasTarget) CardManager.getCurrentCard()).setTarget(monster);
			}
			CardManager.getCurrentCard().use();
		}
		public static void endTurn() {
			CardManager.discard_all();
			MonsterManager.attackTurn();
			System.out.println("monster_attack");
			// Start New Turn
			
			GameLogic.getCardManager().draw(5);
			endTurnButton.setDisable(false);
		}
		
		
		public static ActionManager getActionManager() {
			return actionManager;
		}
		public void setActionManager(ActionManager actionManager) {
			GameLogic.actionManager = actionManager;
		}
		public static MonsterManager getMonsterManager() {
			return monsterManager;
		}
		public static void setMonsterManager(MonsterManager monsterManager) {
			GameLogic.monsterManager = monsterManager;
		}
		public static GridPane getGrid() {
			return grid;
		}
		public static void setGrid(GridPane grid) {
			GameLogic.grid = grid;
		}
		public static CardManager getCardManager() {
			return cardManager;
		}
		public static void setCardManager(CardManager cardManager) {
			GameLogic.cardManager = cardManager;
		}
		public static HBox getCardBox() {
			return cardBox;
		}
		public static void setCardBox(HBox cardBox) {
			GameLogic.cardBox = cardBox;
		}
		public static Scene getScene() {
			return scene;
		}
		public static void setScene(Scene scene) {
			GameLogic.scene = scene;
		}
		public static Node getRoot() {
			return root;
		}
		public static void setRoot(Node root) {
			GameLogic.root = root;
		}
		public static Button getEndTurnButton() {
			return endTurnButton;
		}
		public static void setEndTurnButton(Button endTurnButton) {
			GameLogic.endTurnButton = endTurnButton;
		}
		
		
		
}
