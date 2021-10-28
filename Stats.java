/**
Team Sushi (Ruby Friedman, Joseph Othman, Ivina Wang)
APCS
HW26 -- GCD Three Ways
2021-10-27
time spent: 01.0
DISCO:
 * There is a difference between using a brute force while loop
   and a while loop based iterative algorithm.
 * In certain contexts it's easier to use recursion than a while
   loop, but really it's dependent on personal preference.
 * The GCD of 2 numbers is the same as the gcd of the smaller
   number and the difference between the larger number and the smaller
   number.
QCC:
 * How would we know which loop would be the most efficient to implement
   before encoding them?
 * Why is using a brute force while loop less efficient if the computer
   still preforms it just as fast?
ALGO:
 * If the inputs a and b are equal then return a, if a is greater
   than b return the gcd of a minus b and b, if not then return the
   gcd of a and b minus a. This works due to the given information
   that the GCD of 2 numbers is the same as the gcd of the smaller
   number and the difference between the larger number and the smaller
   number.
*/

import java.lang.Math;
public class Stats {

	public static int gcd( int a, int b ) {
		int counter = 1;
		int answer = 1;
		while ((counter <= a) && (counter <= b)) {
			if ((b % counter == 0) && (a % counter == 0)) {
				answer = counter;
			}
			counter += 1;
		}
		return answer;
	}
	public static int gcdER( int a, int b ) {
		if (a == b) {
			return a;
		}
		else if (a > b){
			return gcd((a-b), b);
		}
		else {
			return gcd(a, (b-a));
		}
	}

	public static int gcdEW( int a, int b ) {
		while (a != b) {
			if (a > b) {
				a = (a - b);
			}
			else {
				b = (b - a);
			}
		}
		return a;
	}

		public static int mean(int a, int b) {
		return ((a + b) / 2);
	}

	public static double mean(double a, double b) {
		return ((a + b) / 2);
	}

	public static int max(int a, int b) {
		if (a >= b) {
			return a;
		}
		else {
			return b;
		}
	}

	public static double max(double a, double b) {
		if (a >= b) {
                        return a;
                }
                else {
                        return b;
                }
	}

	public static int geoMean(int a, int b) {
		int i = 0;
		while ((i * i) <= (a * b)) {
			i = i + 1;
		}
		return i-1;
	}

	public static double geoMean(double a, double b) {
                return Math.sqrt(a * b);
	}

	public static int max(int a, int b, int c) {
		if ((a >= b) && (a >= c)) {
			return a;
		}
		else if ((b >= a) && (b >= c)) {
			return b;
		}
		else {
			return c;
		}
	}

	public static double max(double a, double b, double c) {
                if ((a >= b) && (a >= c)) {
                        return a;
                }
                else if ((b >= a) && (b >= c)) {
                        return b;
                }
                else {
                        return c;
                }
	}

	public static int geoMean(int a, int b, int c) {
                int i = 0;
		if (((a > 0) && (b > 0) && (c > 0)) || ((a < 0) && (b < 0) && (c > 0)) || ((a > 0) && (b < 0) && (c < 0)) || ((a < 0) && (b > 0) && (c < 0))) {
                	while ((i * i * i) <= (a * b * c)) {
                        	i = i + 1;
                	}
			return i - 1;
		}
		else if ((a == 0) || (b == 0) || (c == 0)) {
			return i;
		}
		else {
			while ((i * i * i) >= (a * b * c)) {
				i = i - 1;
			}
			return i + 1;
		}
	}

	public static double geoMean(double a, double b, double c) {
                return (Math.cbrt(a * b * c));
	}
	public static void main(String[] args) {
	        System.out.println(gcd(1, 1));
        	System.out.println(gcd(6, 6));
        	System.out.println(gcd(9, 15));
        	System.out.println(gcd(13, 11));
        	System.out.println(gcd(6, 12));
        	System.out.println(gcdER(1, 1));
        	System.out.println(gcdER(6, 6));
        	System.out.println(gcdER(9, 15));
        	System.out.println(gcdER(13, 11));
        	System.out.println(gcdER(6, 12));
        	System.out.println(gcdEW(1, 1));
        	System.out.println(gcdEW(6, 6));
       		System.out.println(gcdEW(9, 15));
		System.out.println(gcdEW(13, 11));
 	        System.out.println(gcdEW(6, 12));
	}
}
