package gameLogic;
import java.util.ArrayList;
import java.util.Collections;

import exception.NoTargetExcaption;
import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import logicEntities.base.Card;
import logicEntities.base.cardType.hasTarget;
import logicEntities.card.*;
import shareObject.GameConfig;
import shareObject.MousePositionPointer;
/**
 * @author Napat
 * The Class to manage all card in play
 */
public class CardManager {
	private static ArrayList<Card> deck;
	private static ArrayList<Card> onHand;
	private static ArrayList<Card> disCardPile;
	private static Card currentCard;
	private final int drawEachTurn = 5;
	
	/**
	 * Construct the starter deck
	 */
	public CardManager() {
		super();
		deck = new ArrayList<Card>();
		onHand = new ArrayList<Card>();
		disCardPile = new ArrayList<Card>();
		disCardPile.add(new BoarOfDestruction());
		disCardPile.add(new BullOfPower());
		disCardPile.add(new CamelOfProficient());
		disCardPile.add(new GaleOfTravel());
		disCardPile.add(new GoatOfThunder());
		disCardPile.add(new RamWhoDefyDeath());
		disCardPile.add(new RaptorOfWind());
		disCardPile.add(new SwordOfWisdom());
		disCardPile.add(new WhiteStallionOfSun());
		disCardPile.add(new YouthOfProtection());
		disCardPile.add(new MagicBullet());
		disCardPile.add(new MagicShield());
		disCardPile.add(new MagicBullet());
		disCardPile.add(new MagicShield());
		disCardPile.add(new MagicBullet());
		disCardPile.add(new MagicShield());
		disCardPile.add(new MagicBullet());
		disCardPile.add(new MagicShield());
		disCardPile.add(new MagicBullet());
		disCardPile.add(new MagicShield());
		draw(this.drawEachTurn);
	}
	
	/**
	 * Render the card on hand
	 */
	public void renderHand() {
		if(GameLogic.getCardBox()!=null) {
			GameLogic.getCardBox().getChildren().clear();
		}
		for(Card card : onHand) {
			GameLogic.getCardBox().getChildren().add(card.getCard_ob());
			addCardlistener(card);
		}
	}
	/**
	 * Discard card from hand
	 * @param card card to be discard
	 */
	public static void disCard(Card card) {
		int index = onHand.indexOf(card);
		if(index!=-1) {
			disCardPile.add(onHand.get(index));
			onHand.remove(index);
			GameLogic.getCardManager().renderHand();
		}
		
	}
	/**
	 * Draw the card from deck
	 * @param n_draw the number of card to draw
	 */
	public void draw(int n_draw) {
		for(int i=0;i<n_draw;i++) {
			if(deck.size()==0 && disCardPile.size()!=0) {
				reshuffle();
				onHand.add(deck.get(deck.size()-1));
				deck.remove(deck.size()-1);
			}
			else if(deck.size()==0&&disCardPile.size()==0) {
				break;
			}
			else {
				onHand.add(deck.get(deck.size()-1));
				deck.remove(deck.size()-1);
			}
			
		}
		renderHand();
		//System.out.println("Draw done");
	}
	
	/**
	 * Discard all card from hand
	 */
	public static void discard_all() {
		while(onHand.size()!=0) {
			disCardPile.add(onHand.get(onHand.size()-1));
			onHand.remove(onHand.size()-1);
		}
		//System.out.println("Discard done");
	}
	
	/**
	 * Shuffle all card in deck
	 */
	public void reshuffle() {
		while(disCardPile.size()!=0) {
			deck.add(disCardPile.get(disCardPile.size()-1));
			disCardPile.remove(disCardPile.size()-1);
		}
		Collections.shuffle(deck);
	}
	
	/**
	 * Add the card Action
	 * @param card
	 */
	private void addCardlistener(Card card){
		//System.out.println("TESTV@");
		card.getCard_ob().setOnDragDetected(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				Dragboard db = card.getCard_ob().startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content = new ClipboardContent();
				if(card instanceof hasTarget) {
					content.putString("Target");
					
				}else {
					content.putString("NoTarget");
				}
				db.setContent(content);
				MousePositionPointer.getInstance().setCardX(arg0.getSceneX());
				MousePositionPointer.getInstance().setCardY(arg0.getSceneY());
				CardManager.currentCard = card;
				//System.out.print("Test");
				arg0.consume();
			}
		});
		card.getCard_ob().setOnDragDone(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent arg0) {
				MousePositionPointer.getInstance().setIsDragging(false);
				arg0.consume();
			}
		});
	}
	public static ArrayList<Card> getDeck() {
		return deck;
	}
	public static void setDeck(ArrayList<Card> deck) {
		CardManager.deck = deck;
	}
	public static ArrayList<Card> getOnHand() {
		return onHand;
	}
	public static void setOnHand(ArrayList<Card> onHand) {
		CardManager.onHand = onHand;
	}
	public static ArrayList<Card> getDisCardPile() {
		return disCardPile;
	}
	public static void setDisCardPile(ArrayList<Card> disCardPile) {
		CardManager.disCardPile = disCardPile;
	}

	public static Card getCurrentCard() {
		return currentCard;
	}

	public static void setCurrentCard(Card currentCard) {
		CardManager.currentCard = currentCard;
	}
	
}
