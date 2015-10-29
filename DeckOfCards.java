package hw3;

import java.util.ArrayList;
import java.util.Collections;


public class DeckOfCards {

	//1. instance variables
	private ArrayList<PokerCard> deck = new ArrayList<PokerCard>();

	//2. constructor
	
	/**
	 * Fill the deck (an ArrayList) with all 52 PokerCard objects
	 * Shuffle the card
	 */
	public DeckOfCards(){
		for (int i=0; i < 4; i++){
			for (int j = 1; j < 14; j++){
				deck.add(new PokerCard(i, j));
			}
		}
		Collections.shuffle(deck);
	}
	
	/**
	 * 
	 * Deal cards. Without actually implement a queue with LinkedList,
	 * the deck deals the first card and removes it from the ArrayList
	 * Note that there is NO ENQUEUE - one deck only
	 * @return the drawn PokerCard
	 */
	public PokerCard dequeue(){
		if (isEmpty()) throw new RuntimeException("Deck Fully Drawn"); //throw Exception - caught by BlackjackTester
		PokerCard out = deck.get(0);
		deck.remove(0);
		return out;
	}
	

	/**
	 * Test if the deck is all drawn
	 * @return boolean result of the test
	 */
    public boolean isEmpty() {
        return deck.isEmpty();
    }
    
    /**
     * 
     * @return how many cards are left in the deck
     */
    public int checkDeckSize(){
    	return deck.size();
    }
    


}
