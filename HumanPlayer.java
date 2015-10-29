package hw3;

import java.util.Scanner;

public class HumanPlayer {

	// HumanPlayer class only acts as a decision maker
	// Decides to hit or stay

	// 1. instance

	private Scanner sc;
	private GenericPlayer playa;
	private DeckOfCards deck;

	// 2. constructor

	/**
	 * 
	 * @param human - HumanPlayer basically inherits from a GenericPlayer
	 * @param deckIn - Make sure we use the leftover cards in a deck, instead of a new deck
	 */
	public HumanPlayer(GenericPlayer human, DeckOfCards deckIn) {
		sc = new Scanner(System.in);
		playa = human;
		deck = deckIn;
	}

	// 3. methods

	/**
	 * Prompt user to hit or stay
	 * @return hit or stay decision
	 */
	public boolean getDecision() {
		System.out.println("(h)it or (s)tay?");

		char decision = sc.next().charAt(0);
		if (decision == 'h' || decision == 'H') {
			return true;
		} else if (decision == 's' || decision == 'S') {
			return false;
		} else {
			System.out.println("Incorrect input. Try again with only 'h' or 's'");
			return getDecision();
		}
	}

	/**
	 * User plays a round just like a typical Blackjack game
	 * @return final score of the round
	 */
	public int play() {
		System.out.println("Your current score is: " + playa.countHand());
		System.out.println("Your turn.");
		while (playa.countHand() < 22) {
			if (getDecision()) {
				PokerCard temp = deck.dequeue();
				System.out.println("You drew " + temp.getCardName());
				playa.add(temp);
				System.out.println("Your current score is: "+ playa.countHand());
			} else {
				int finalScore = playa.countHand();
				System.out.println("You are done. Your score is " + finalScore);
				return finalScore;
			}
		}
		return playa.countHand();
	}
}
