/**
Team Sushi (Ruby Friedman, Joseph Othman, Ivina Wang)
APCS
HW29 -- Which Way Do You Roll?
2021-11-2
time spent: 01.0
DISCO:
 * Learned how to use FOREACH loop in the main method
 * To convert from int to String, create a String value
   and assign it the value of an empty String plus that
   int. For example: int x; String y = "" + x;
 * To convert from String to int use syntax Integer.parseInt(s)
   where s represents a String.
 * When we run a java file using java <file name> we can give it
   inputs.
QCC:
 * If there is String addition where you add a String to the end
   of a String using the plus opperator, is there String subtraction,
   and if so, what is the syntax for it?
 * What would happen if we used negative int values?
*/
public class Commafier {

	public static String commafyR(int x) {
		String input = "" + x;
                int length = input.length();
                if (length <= 3) {
                        return input;
		}
		else {
			String helper = input.substring(0, length-3);
			int help = Integer.parseInt(helper);
			return "" + commafyR(help) +  "," + input.substring(length-3);
		}
	}

	public static String commafyF(int x) {
		String input = "" + x;
		int length = input.length();
		String output = "";
		if (length <= 3) {
			return input;
		}
		for (int i = 3; i < length; i = i+3) {
			output = "," + input.substring(length-i) + output;
			input = input.substring(0, length-i);
		}
		output = input + output;
		return output;
	}

	public static void main(String[] args) {
		for (String s: args) {
			int input = Integer.parseInt(s);
			System.out.println(commafyR(input));
		}
/**		System.out.println(commafyR(1));
        	System.out.println(commafyR(10));
        	System.out.println(commafyR(101));
        	System.out.println(commafyR(1000));
        	System.out.println(commafyR(12354));
        	System.out.println(commafyR(123456789));
	        System.out.println(commafyF(1));
		System.out.println(commafyF(10));
        	System.out.println(commafyF(101));
        	System.out.println(commafyF(1000));
        	System.out.println(commafyF(12345));
        	System.out.println(commafyF(123456789)); */
	}
}
