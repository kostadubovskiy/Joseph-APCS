public class Greet {
	public static void main (String[] args) {
<<<<<<< HEAD
		System.out.println(greet(No hablo queso));

	}
	public static void greet(String x) {
		System.out.println(x);
	}
=======
		System.out.println(t);
		System.out.println(a+q+b);
		System.out.println(a+r+b);
	}

	public static String greet(String x) {
		return x;
	}

	static String a = "Why, hello there, ";
	static String b = ". How do you do?";
	static String p = "John";
	static String q = "Jacob";
	static String r = "Josiah";
	static String t = a + p + b;

/*
*DISCOVERIES
- string concatenation works in java the same as it did in python.
- nonstatic variables cannot be references in static
*/

/*
UNRESOLVED MYSTERIES
- how do we write the code to give us one of the three hello messages?
*/
>>>>>>> bd0d27dda6616af6374cd2aa7172d8232295dd53
}
