package hw3;

import java.util.HashMap;

/**
 * 
 * A poker card has 2 features: suits and card number, each represented by an
 * integer. In addition, we will initialize the two hash maps. One maps suits
 * index (0 to 3) to suits names in string (Spades and etc.) Another maps card
 * number index (1 to 13) to actual card values (Ace to King)
 * 
 * @author Qi_He
 *
 */

public class PokerCard {

	//1. instance variables
	
	private int suits;
	private int cardNumber;
	
	//Set the suits maps public if the user wants to change the order of suits
	//But kept the valueMap private as it is more straightforward.
	//Also added getters for suits maps for future use.
	public HashMap<Integer, String> suitsMap = new HashMap<Integer, String>();
	private HashMap<Integer, String> valueMap = new HashMap<Integer, String>();

	//2. initialize

	/**
	 * Initialize the features of a card and the mappings.
	 * @param suitsIndex - see SuitsMap
	 * @param number - card number
	 */
	public PokerCard(int suitsIndex, int number){
		suits = suitsIndex;
		cardNumber = number;

		//fill map: mapping suits index to actual suits
		suitsMap.put(0, "Spades");
		suitsMap.put(1, "Hearts");
		suitsMap.put(2, "Clubs");
		suitsMap.put(3, "Diamonds");
	
		//fill map: mapping card index to actual card values (Ace, 1, ..., Queen, King)
		valueMap.put(1, "Ace");
		for (int i = 2; i <= 10; i++){
			valueMap.put(i, Integer.toString(i));
		}
		valueMap.put(11, "Jack");
		valueMap.put(12, "Queen");
		valueMap.put(13, "King");

	}

	//3. getters

	/**
	 * 
	 * @return suits index
	 */
	public int getSuitsIndex(){
		return suits;
	}

	/**
	 * This method only gets the number of the card (King:13, Ace:1);
	 * This does not give the actual value that would be counted in blackjack game.
	 * @return card number as integer
	 */
	public int getCardNumber(){
		return cardNumber;
	}

	/**
	 * This method gets the card as a string. For example: King of Spades, 5 of Hearts.
	 * @return a string of card name
	 */
	public String getCardName(){
		String suitsName = suitsMap.get(suits);
		String value = valueMap.get(cardNumber);
		return value + " of " + suitsName;
		
	}
	
	/**
	 * SuitsMap getter
	 * @param suitsIndex
	 * @return string name of the suits by index
	 */
	public String findSuitsName(int suitsIndex){
		return suitsMap.get(suitsIndex);
	}
	
}
