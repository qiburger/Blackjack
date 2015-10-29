package hw3;

/*
 * This class represents a game of Blackjack, 
 * which can be played by a human player or automated strategy.
 * 
 */
public class Blackjack {

	// 1. instance
	private DeckOfCards deck;

	// 2. constructor
	/**
	 * 
	 * Per Swap, every round should start with a new deck of cards. The input
	 * dictates which type of play we run: 0 -> human vs. computer 1 ->
	 * optimized strategy vs. computer
	 */
	public Blackjack() {
	}

	/**
	 * This method tests which type of play we run
	 * @param playerIndex -  0 -> human to computer, 1 -> optimal player to computer
	 * @return result of the round: 0: Player wins. 1: Computer wins; 2: tie; -1: error.
	 */
	public int playOneRound(int playerIndex) {
		deck = new DeckOfCards();
		
		if (playerIndex == 0) { 
			return humanRound();
		} else if (playerIndex == 1) { 
			return optimalPlay();
		} else {
			System.out
					.println("Currently the system does not yet support human to human, or computer to computer play");
			return -1;
		}
	}

	/**
	 * The follow method represents a human vs computer game
	 * @return result of the round, as explained in PlayOneRound
	 */
	private int humanRound() {

		int results; 

		System.out.println("Let's play some BlackJack!");
		System.out.println("Dealing cards...");

		// Draw the first 4 cards
		PokerCard card1 = deck.dequeue();
		PokerCard card2 = deck.dequeue();
		PokerCard card3 = deck.dequeue();
		PokerCard card4 = deck.dequeue();

		System.out.println("Player has " + card1.getCardName() + " and " + card2.getCardName());
		System.out.println("Computer first draws " + card3.getCardName());

		GenericPlayer human = new GenericPlayer(card1, card2); //make a GenericPlayer for HumanPlayer class
		GenericPlayer computer = new GenericPlayer(card3, card4); //make a GenericPlayer for ComputerPlayer

		HumanPlayer playa = new HumanPlayer(human, deck); //Human plays first

		int humanScore = playa.play(); //Human plays a round

		if (humanScore < 22) {
			System.out.println("Now it is computer's turn.");
			System.out.println("Computer's second card is " + card4.getCardName());

			//Now computer plays with the cards left over in the deck
			ComputerPlayer cyborg = new ComputerPlayer(computer, deck); 
			int computerScore = cyborg.play(); //computer plays a round

			if (computerScore > 21) {
				results = 0;
				System.out.println("Computer busts. Player won!");
			} else if (computerScore > humanScore) {
				results = 1;
				System.out.println("Computer won!");
			} else if (computerScore == humanScore) {
				results = 2;
				System.out.println("It's a tie!");
			} else {
				results = 0;
				System.out.println("Player won!");
			}

		} else {
			results = 1;
			System.out.println("Player busts. Computer won!");
		}

		return results;

	}

	/**
	 * Play with an optimal strategy
	 * @return result of the round as explained above
	 */
	private int optimalPlay() { //We will skip the print instructions for automated play.

		//Most of the instructions below are the same as above.
		int results; // 0: Strategy wins. 1: Computer wins; 2: tie.

		System.out.println("Blackjack using (relatively) optimal strategy");

		PokerCard card1 = deck.dequeue();
		PokerCard card2 = deck.dequeue();
		PokerCard card3 = deck.dequeue();
		PokerCard card4 = deck.dequeue();

		GenericPlayer human = new GenericPlayer(card1, card2);
		GenericPlayer computer = new GenericPlayer(card3, card4);

		// Here OptimalPlayer peaks the computer's shown card to make a decision
		OptimalPlayer playa = new OptimalPlayer(human, deck, card3);

		int humanScore = playa.play();

		if (humanScore < 22) {
			System.out.println("Now it is computer's turn.");

			ComputerPlayer cyborg = new ComputerPlayer(computer, deck);
			int computerScore = cyborg.play();

			if (computerScore > 21) {
				results = 0;
				System.out.println("Computer busts. Player won!");
			} else if (computerScore > humanScore) {
				results = 1;
				System.out.println("Computer won!");
			} else if (computerScore == humanScore) {
				results = 2;
				System.out.println("It's a tie!");
			} else {
				results = 0;
				System.out.println("Player won!");
			}

		} else {
			results = 1;
			System.out.println("Player busts. Computer won!");
		}

		return results;

	}

}
