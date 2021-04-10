package gameLogic;
import java.util.ArrayList;
import java.util.Collections;

import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import logicEntities.base.Card;
import logicEntities.card.Fireball;
import shareObject.GameConfig;
import shareObject.SecondSceneObjectHolder;
public class CardManager {
	private static ArrayList<Card> deck;
	private static ArrayList<Card> onHand;
	private static ArrayList<Card> disCardPile;
	private static Card currentCard;
	
	
	public CardManager() {
		super();
		deck = new ArrayList<Card>();
		onHand = new ArrayList<Card>();
		disCardPile = new ArrayList<Card>();
		disCardPile.add(new Fireball());
		disCardPile.add(new Fireball());
		disCardPile.add(new Fireball());
		disCardPile.add(new Fireball());
		disCardPile.add(new Fireball());
		draw(5);
	}
	
	public void renderHand() {
		if(GameLogic.getCardBox()!=null) {
			GameLogic.getCardBox().getChildren().clear();
		}
		for(Card card : onHand) {
			GameLogic.getCardBox().getChildren().add(card.getCard_ob());
			addCardlistener(card);
		}
	}
	public static void disCard(Card card) {
		int index = onHand.indexOf(card);
		disCardPile.add(onHand.get(index));
		onHand.remove(index);
		GameLogic.getCardManager().renderHand();
	}
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
		System.out.println("Draw done");
	}
	
	public static void discard_all() {
		while(onHand.size()!=0) {
			disCardPile.add(onHand.get(onHand.size()-1));
			onHand.remove(onHand.size()-1);
		}
		System.out.println("Discard done");
	}
	
	public void reshuffle() {
		while(disCardPile.size()!=0) {
			deck.add(disCardPile.get(disCardPile.size()-1));
			disCardPile.remove(disCardPile.size()-1);
		}
		Collections.shuffle(deck);
	}
	
	private void addCardlistener(Card card) {
		card.getCard_ob().setOnDragDetected(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				Dragboard db = card.getCard_ob().startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content = new ClipboardContent();
				content.putString(card.getCard_ob().getImage().toString());
				db.setContent(content);
				SecondSceneObjectHolder.getInstance().setCardX(arg0.getSceneX());
				SecondSceneObjectHolder.getInstance().setCardY(arg0.getSceneY());
				CardManager.currentCard = card;
				System.out.print("Test");
				arg0.consume();
			}
		});
		card.getCard_ob().setOnDragDone(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent arg0) {
				SecondSceneObjectHolder.getInstance().setIsDragging(false);
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
