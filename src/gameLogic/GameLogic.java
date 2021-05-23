package gameLogic;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import gameLogic.action.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import logicEntities.Player;
import logicEntities.base.Monster;
import logicEntities.base.cardType.hasTarget;
import shareObject.StageIndex;
/**
 * @author Napat
 * Class to manage the Game flow
 */
public class GameLogic {
		private static ActionManager actionManager;
		private static MonsterManager monsterManager;
		private static CardManager cardManager;
		private static GridPane grid;
		private static HBox cardBox;
		private static Scene scene;
		private static Node root;
		private static Button endTurnButton;
		private static boolean isActionRunning = false;
		private static int turnPass = 0;
		private static int result;
		private static int round=0;
		private static int drawEachTurn = 5;
		/**
		 * Init the manager
		 */
		public static void init() {
			GameLogic.actionManager = new ActionManager();
			GameLogic.monsterManager = new MonsterManager();
			GameLogic.cardManager = new CardManager();
			Player.getInstance();
		}
		/**
		 * Run the action in queue
		 */
		public static void runAction() {
			actionManager.runAction();
			BuffManager.updateBuff();
		}
		/**
		 * Add the action to queue
		 * @param monster the target monster
		 */
		public static void addAction(Monster monster) {
			GameLogic.getCardManager();
			if(CardManager.getCurrentCard() instanceof hasTarget) {
				((hasTarget) CardManager.getCurrentCard()).setTarget(monster);
			}
			CardManager.getCurrentCard().use();
		}
		/**
		 * End turn
		 */
		public static void endTurn() {
			CardManager.discard_all();
			GameLogic.getMonsterManager().monsterAction();
			System.out.println("monster_attack");
			Player.getInstance().setMana(Player.getInstance().getMana_max());
			// Start New Turn

			GameLogic.getCardManager().draw(GameLogic.drawEachTurn);
			endTurnButton.setDisable(false);
		}
		/**
		 * Start transitionScene (Winlose Screen)
		 * @param result
		 */
		public static void gameTransition(int result) {
			// 0 = lose , 1 = win
			GameLogic.setResult(result);
			StageIndex.getInstance().setstageIndex(StageIndex.Transition);
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
		public static boolean isActionRunning() {
			return isActionRunning;
		}
		public static void setActionRunning(boolean isActionRunning) {
			GameLogic.isActionRunning = isActionRunning;
		}
		public static int getTurnPass() {
			return turnPass;
		}
		public static void setTurnPass(int turnPass) {
			GameLogic.turnPass = turnPass;
		}
		public static int getResult() {
			return result;
		}
		public static void setResult(int result) {
			GameLogic.result = result;
		}
		public static int getRound() {
			return round;
		}
		public static void setRound(int round) {
			GameLogic.round = round;
		}
		
		
		
}
