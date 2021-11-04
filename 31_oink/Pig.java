/***
 * Team Sushi (Ruby Friedman, Joseph Othman, Ivina Wang)
 * APCS
 * HW31 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
 * 2021-11-04
 * time spent: 0.8hrs
 *
 * class Pig
 * a Pig Latin translator
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
DISCO:
 * When initializing a variable, use the keyword final so that
   the variables value is never changed. For example, String
   VOWELS will always have the value "aeiou" even if you try to
   re-assign it a new value.
 * Invoking another method within a method can act as a helper
   procedure to make the method more efficent.
 * <stringname>.indexOf(<charecter>) returns the value of the first
   index where the charecter appears in <stringname>
QCC:
 * String VOWELS does not include the upper-case vowels, and since
   java is case sensitive, wouldn't this overlook some of the vowel
   cases?
 * What other methods are neccesary to make a pig latin translator?
 ***/

public class Pig {
	//Q: How does this initialization make your life easier?
	private static final String VOWELS = "aeiou";


	/*=====================================
	boolean hasA(String,String) -- checks for a letter in a String
	pre:  w != null, letter.length() == 1
 	post: hasA("cat", "a") -> true
	hasA("cat", "p")       -> false
	=====================================*/
	public static boolean hasA( String w, String letter ) {
	/* YOUR IMPLEMENTATION HERE */
		int counter = 0;
		while (counter < w.length()) {
			if ((w.substring(counter, counter+1)).equals(letter)) {
				return true;
			}
			counter += 1;
		}
		return false;
	}//end hasA()


	/*=====================================
	boolean isAVowel(String) -- tells whether a letter is a vowel
	precondition: letter.length() == 1
	=====================================*/
	public static boolean isAVowel( String letter ) {
	/* YOUR IMPLEMENTATION HERE */
		int counter = 0;
		while (counter < VOWELS.length()) {
			if ((VOWELS.substring(counter, counter+1)).equals(letter)) {
				return true;
			}
			counter += 1;
		}
		return false;
	}


	/*=====================================
	int countVowels(String) -- counts vowels in a String
	pre:  w != null
	post: countVowels("meatball") -> 3
	=====================================*/
	public static int countVowels( String w ) {
	/* YOUR IMPLEMENTATION HERE */
		int counter = 0;
		int result = 0;
		while (counter < w.length()) {
			if (isAVowel(w.substring(counter, counter+1)) == true) {
				result += 1;
			}
			counter += 1;
		}
		return result;
	}


	/*=====================================
	boolean hasAVowel(String) -- tells whether a String has a vowel
	pre:  w != null
	post: hasAVowel("cat") -> true
	hasAVowel("zzz")       -> false
	=====================================*/
	public static boolean hasAVowel( String w ) {
	/* YOUR IMPLEMENTATION HERE */
		if (countVowels(w) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/*=====================================
	String allVowels(String) -- returns vowels in a String
	pre:  w != null
	post: allVowels("meatball") -> "eaa"
	=====================================*/
	public static String allVowels( String w ) {
	/* YOUR IMPLEMENTATION HERE */
		int counter = 0;
		String results = "";
		while (counter < w.length()) {
			if (isAVowel(w.substring(counter, counter+1)) == true) {
				results += w.substring(counter, counter+1);
			}
			counter += 1;
		}
		return results;
	}


	public static void main( String[] args ) {
	/* YOUR TEST CALLS HERE */
		System.out.println(hasA("cat", "a"));
		System.out.println(hasA("cat", "p"));
                System.out.println(isAVowel("i"));
                System.out.println(isAVowel("k"));
		System.out.println(countVowels("meatball"));
		System.out.println(countVowels("turtle"));
		System.out.println(hasAVowel("cat"));
		System.out.println(hasAVowel("zzz"));
		System.out.println(allVowels("meatball"));
		System.out.println(allVowels("turtle"));
	}//end main()

}//end class Pig
