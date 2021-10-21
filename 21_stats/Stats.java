/**
Team Sushi- Ruby Friedman, Joseph Othman, Ivina Wang
APCS
HW21 -- STAtisTically Speaking...
2021-10-20

TASK:
Implement each method without typecasting.
**/

import java.lang.Math;
public class Stats {

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


    //main method for testing functionality
    public static void main( String[] args ) {
        System.out.println(mean(0, 6)); //should return 3
                System.out.println(mean(3, 3)); //should return 3
                System.out.println(mean(4.0, 5.2)); //should return 4.6
                System.out.println(max(5, 8)); //should return 8
                System.out.println(max(-8, 8, 2)); //should return 8
                System.out.println(max(0, 0, 0)); //should return 0
                System.out.println(geoMean(3, 3)); //should return 3
                System.out.println(geoMean(3, -3, -3)); //should return 3
                System.out.println(geoMean(-1, -8, -27)); //should return -6
                System.out.println(geoMean(0, 1.0, 3.0)); //should return 0.0

    }

}//end class
