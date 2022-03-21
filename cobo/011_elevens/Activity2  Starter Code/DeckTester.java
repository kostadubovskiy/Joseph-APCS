/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] cardsInDeck = {"Ace", "King", "Queen", "Jack"};
		String[] suitsInDeck = {"Spades", "Hearts", "Clubs", "Diamonds"};
		int[] pointsInDeck = {4,3,2,1};

		Deck Kosta = new Deck(cardsInDeck, suitsInDeck, pointsInDeck);
		System.out.println(Kosta);
		Kosta.deal();
		System.out.println(Kosta);
	}
}
