public class PigTests {

	private static final String VOWELS = "aeiou";

	public static void main(String[] args) {
		System.out.println("Hello!\t" + "What's up?");
		System.out.println(hasAVowel("twenty"));
		System.out.println(hasAVowel("rhythm"));
		System.out.println(hasAVowel("zzzzzz"));
	}

	public static boolean hasAVowel( String w ) {
		return w.indexOf(w) >= 0;
	}


}
