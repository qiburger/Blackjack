package hw3;

import java.util.Scanner;

import javax.management.RuntimeMBeanException;

public class BlackjackTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int roundsPlayed = 0; //how many rounds of game played
		int playerWins = 0; //how many times the human player / optimal strategy won
		int ties = 0; // how many tie games are there

		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to play Human vs Computer? If so, enter 0.");
		System.out.println("Or press 1 to test automated strategy");
		int gameIndex = sc.nextInt(); // Will feed into playOneRound method

		Blackjack game = new Blackjack(); 

		System.out.println("Now how many rounds of games would you like to play?");
		System.out.println("Enter an integer (e.g. 1000): ");

		int roundCount = sc.nextInt();

		// Start Monte Carlo
		for (int i = 0; i < roundCount; i++) {
			try { //catch exception when a deck is drawn
				int result_temp = game.playOneRound(gameIndex); // 0: Player wins.
																// 1: Computer wins.
																// 2: tie.
				roundsPlayed++;
				if (result_temp == 0) {
					playerWins++;
				} else if (result_temp == 2) {
					ties++;
				}
			} 
			//Should never occur since we make a new deck per round
			//But left it here in case we change how the deck draws
			catch (RuntimeMBeanException exc) { 
				break;
			}
		}

		System.out.println("Total rounds played: " + roundsPlayed);
		System.out.println("Player has won: " + playerWins);
		System.out.println("Number of ties: " + ties);
		int computerWins = roundsPlayed - playerWins - ties;
		System.out.println("Computer has won: "+ computerWins);
		System.out.println("Player winning %: " + ((float) playerWins / roundsPlayed));
		System.out.println("Computer winning %: " + ((float) computerWins / roundsPlayed));

		sc.close();
	}

}
