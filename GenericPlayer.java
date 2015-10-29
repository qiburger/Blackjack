package hw3;

import java.util.ArrayList;

public class GenericPlayer {
	// The Player class is a general abstraction of any player, computer or
	// human
	// The Player class primarily holds the cards and counts the total score.

	// Player's cards
	private ArrayList<PokerCard> hand = new ArrayList<PokerCard>();

	// Tracks the sum of all cards in player's hand
	private int totalHand;
	
	/**
	 * Initiate any player with two cards
	 * @param card1 - first card dealt
	 * @param card2 - second card dealt
	 */
	public GenericPlayer(PokerCard card1, PokerCard card2) {
		hand.add(card1);
		hand.add(card2);
		totalHand = countHand();
	}

	/**
	 * Count hand: use 11 for Ace until it's bust
	 * @return the current score of the hand
	 */
	public int countHand() {
		totalHand = 0;
		boolean containsAce = false;
		for (PokerCard cards : hand) {
			if (cards.getCardNumber() > 1) {
				totalHand += Math.min(cards.getCardNumber(), 10);
			}
			if (cards.getCardNumber() == 1) {
				if (!containsAce) {
					totalHand += 11; // set the value of Ace to 11 only for the
										// first Ace
				} else {
					totalHand += 1;
				}
				containsAce = true;
			}
		}
		// When the player is bust, it can convert the ace back down to 1 (thus
		// minus 10)
		if (containsAce && totalHand > 22) {
			totalHand -= 10;
		}

		return totalHand;

	}

	/**
	 * "hit"
	 * @param card1 - drawn card from the deck
	 */
	public void add(PokerCard card1) {
		hand.add(card1);
	}
	
	/**
	 * This method is used for optimizing our strategy:
	 * When a player start with an Ace, the optimal strategy is different
	 * @return whether the first two cards have at least one Ace
	 */
	public boolean hasAce(){
		return (hand.get(0).getCardNumber() == 1 || hand.get(1).getCardNumber() == 1);
	}

}
