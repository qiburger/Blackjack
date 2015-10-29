
Getting Started

The BlackjackTester is like an interface for users to decide what kind of game to play and how many rounds of game he/she would like to run. Enter 0 to actually play against the dealer (computer), or enter 1 to essentially run Monte Carlo simulations to test the optimal strategy.

To play a game the tester will create a Blackjack instance, and use its playOneRound method to play one round of game (with type of game specified above). 

Blackjack Class

This class encapsulates the way a human or an optimal strategy would play the game. Each game would create a new DeckOfCards object, two GenericPlayer objects, a huamn/optimized human object, and a ComputerPlayer object. Then it will play the game based on the rule of Blackjack, including how to deal cards, when a player is bust, how a player wins and etc. 

DeckOfCards

Abstraction of a deck of poker cards, where each card is a PokerCard object. The deck is randomly shuffled when created, and dealing a card as like a dequeue method on a queue. 

PokerCard

Abstraction of a poker card, which has two features: suits and card number. 

GenericPlayer

To be honest, I designed this so that a human player and a computer player can inherit from. But we haven't learned it. The GenericPlayer class include basic operations like countHand (count total score in a player's hand) and add. These methods apply to both human and computer players.

ComputerPlayer

Initiate with a GenericPlayer, but decides how to play based on house rules in Blackjack.

HumanPlayer

Similar to ComputerPlayer, but the way it plays is based on user inputs. So it acts as an interface for user to play the game.

OptimalPlayer




CRC

A few things to quickly explain: added Blackjack class in addition to the tester to call optimal strategy easily.
Set up DeckOfCards to implement the queue, and PokerCard to create an object with two features (suits and number)

Here are the things that changed:
Originally I did not have the GenericPlayer class, with the human and computer players as two separate classes. But then the countHand  and add methods would repeat itself. Technically human and computer players should inherit from a player class. So I set up a separate GenericPlayer class, where both human and computer player would initiate and use to calculate their scores and add cards. Now, the huamn and computer players each has a class that deals with how it plays the game (i.e. decision process). 

Other minor changes include: removed Array in PokerCards and only use two integers to represent the two features of a poker card - suits and number. Removed user's ability to convert Aces voluntarily. Instead, the program automatically converts the Ace to appropriate number.


OptimalPlayer / EC
See ec.txt

