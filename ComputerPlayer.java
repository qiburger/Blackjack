package hw3;

public class ComputerPlayer {

	private GenericPlayer cyborg;
	private DeckOfCards deck;

	/**
	 * Initiate a ComputerPlayer class that decides how computer plays
	 * @param computer - GenericPlayer for counting scores and "hitting"
	 * @param deckIn - Pass in the leftover deck from the game to draw
	 */
	public ComputerPlayer(GenericPlayer computer, DeckOfCards deckIn) {
		cyborg = computer;
		deck = deckIn;
	}

	/**
	 * Computer plays the game (based on dealer rules)
	 * @return the score at the end of the round
	 */
	public int play() { 
		while (cyborg.countHand() < 17) { //Based on dealer rules
			//"hit":
			PokerCard temp = deck.dequeue(); 
			System.out.println("Computer draws " + temp.getCardName());
			cyborg.add(temp);
		}
		int score = cyborg.countHand();
		System.out.println("Computer is done, with the score of " + score);
		return score;
	}

}
