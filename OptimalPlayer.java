package hw3;

public class OptimalPlayer {

	// HumanPlayer class only acts as a decision maker
	// Decides to hit or stay

	// 1. instance

	private GenericPlayer playa;
	private DeckOfCards deck;
	private PokerCard dealerCard;

	// 2. constructor

	/**
	 * Similar to HumanPlayer, but we want to peak the first dealer card
	 * @param human
	 * @param deckIn
	 * @param computerFirstCard - Peaking this card gives us better strategies
	 */
	public OptimalPlayer(GenericPlayer human, DeckOfCards deckIn, PokerCard computerFirstCard) {
		playa = human;
		deck = deckIn;
		dealerCard = computerFirstCard;
	}

	/**
	 * Play method implements the basic strategy
	 * @return final score
	 */
	public int play() {
		while (playa.countHand() < 22) {
			if (playa.hasAce()){ // "Soft" scenario
				if (dealerCard.getCardNumber() < 9 && dealerCard.getCardNumber() != 1){ 
					if (playa.countHand()<18){ //dealer has 2-8:  player hits with 13-17
						PokerCard temp = deck.dequeue();
						playa.add(temp);
					}
					else{
						return playa.countHand();
					}
				}
				else {
					if (playa.countHand()<19){ //dealer has 9-A: player hits with 13-18
						PokerCard temp = deck.dequeue();
						playa.add(temp);
					}
					else{
						return playa.countHand();
					}
				}
					
				}
			
			else{
				if (dealerCard.getCardNumber() < 4 && dealerCard.getCardNumber() > 1){ 
					if (playa.countHand() < 13){ //dealer has 2-3: player hits with 4-12
						PokerCard temp = deck.dequeue();
						playa.add(temp);
					}
					else{
						return playa.countHand();
					}
				}
				else if (dealerCard.getCardNumber() < 7 && dealerCard.getCardNumber() > 3){
					if (playa.countHand() < 12){ //dealer has 4-6: player hits with 4-11;
						PokerCard temp = deck.dequeue();
						playa.add(temp);
					}
					else{
						return playa.countHand();
					}
				}
				else{
					if (playa.countHand() < 17){ //dealer has 7-A: player hits with 4-16
						PokerCard temp = deck.dequeue();
						playa.add(temp);
					}
					else{
						return playa.countHand();
					}
				}
			}

		}
		return playa.countHand();
	}
}
