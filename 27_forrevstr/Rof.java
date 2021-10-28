/**
Joseph Othman, Jaylen Zeng, Jason Yang
APCS
HW27 -- FOR the Love of Strings
2021-10-28
time spent: 0.6


DISCO:
 - We learned how to use the String.length() and String.substring(int x, int y) commands.
 - We learned the syntax of for loops, and how to use them to create methods involving reversing strings.
 - The index of a string starts from 0 (like python), and ends at x-1. The String.substring(int x, int y) command
   returns the substring starting from index x (inclusive) up until index y (exclusive).
QCC:
 - When should we use for loops? Other from syntax, what differences are there between for loops and while loops?
 - Are some methods impossible to create without using loops?
**/





public class Rof {

	public static void main(String[] args) {
		System.out.println(fenceF(0));
		System.out.println(fenceF(1));
		System.out.println(fenceF(2));
		System.out.println(fenceF(3));
		System.out.println(fenceF(6));
		System.out.println(reverseF("five"));
		System.out.println(reverseF("stressed"));
		System.out.println(reverseF("desserts"));
		System.out.println(reverseR("five"));
		System.out.println(reverseR("a"));
                System.out.println(reverseR("tw"));
		System.out.println(reverseR("stressed"));
                System.out.println(reverseR("desserts"));
		System.out.println(reverseR("a"));
		System.out.println(reverseR("tw"));
	}

	public static String fenceF(int posts) {
		String ans = "|";
		if (posts == 0) {
			return "";
		}
		else {
			for(int i = 1; i < posts; i++) {
				ans = ans + "--|";
			}
			return ans;
		}
	}

	public static String reverseF(String s) {
		String ans = "";
		int x = s.length();
		for(int i = 0; i < x; i++) {
			ans = ans + s.substring(x-i-1,x-i);
		}
		return ans;
	}

	public static String reverseR(String s) {
		int x = s.length();
		if (x <= 1) {
			return s;
		}
		else {
			return s.substring(x-1) + reverseR(s.substring(0,x-1));
		}
	}

}
