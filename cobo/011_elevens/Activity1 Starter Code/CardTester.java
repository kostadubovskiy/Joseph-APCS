/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card KDubs = new Card("2", "Spades", 3);
		Card JOthman = new Card("3", "Clubs", 2);
		Card Fuuuuuchs = new Card("4", "Hearts", 1);

		Card KDubsClone = new Card("2", "Spades", 3);

		System.out.println(KDubs);
		System.out.println(KDubs.rank());
		System.out.println(KDubs.suit());
		System.out.println(KDubs.pointValue());
		System.out.println("~~~~~~~~~~~~KDubs ^ ~~~~~~~~~~~~~~~");

		System.out.println(JOthman);
		System.out.println(JOthman.rank());
		System.out.println(JOthman.suit());
		System.out.println(JOthman.pointValue());
		System.out.println("~~~~~~~~~~~~JOthman ^ ~~~~~~~~~~~~~~~");

		System.out.println(Fuuuuuchs);
		System.out.println(Fuuuuuchs.rank());
		System.out.println(Fuuuuuchs.suit());
		System.out.println(Fuuuuuchs.pointValue());
		System.out.println("~~~~~~~~~~~~Fuuuuuchs ^ ~~~~~~~~~~~~~~~");

		System.out.println("Testing matches with KDubs, KDubsClone");
		System.out.println(KDubs.matches(KDubsClone));

		System.out.println("Testing matches with JOthman, Fuuuuuchs");
		System.out.println(JOthman.matches(Fuuuuuchs));

	}
}
