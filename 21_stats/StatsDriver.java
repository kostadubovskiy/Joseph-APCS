/**
Team Sushi- Ruby Friedman, Joseph Othman, Ivina Wang
APCS
HW21 -- STAtisTically Speaking...
2021-10-20

DISCO:
- How to use the while conditional loop to avoid lossy conversion from double to int.
- Multiple test cases  using edge cases and different inputs help us determine if the code
  is robust
- import java.lang.Math to use math functions like sqrt() and cbrt()

QCC:
- how do we avoid lossy conversion (without type casting) better?- does Math.round() work?
- What other math functions does java.lang.Math import?
- How many test cases on average should we be using to check for robust code?
*/


public class StatsDriver {
    public static void main(String[] args) {
        System.out.println(Stats.mean(1, 5)); //should return 3
        System.out.println(Stats.mean(1, 4)); //should return 2
        double a = 1;
        double b = 4;
        System.out.println(Stats.mean(a, b));//should return 2.5
        System.out.println(Stats.mean(0, 6)); //should return 3
        System.out.println(Stats.mean(3, 3)); //should return 3
        System.out.println(Stats.mean(-3.0, a));//should return -1.0
        System.out.println(Stats.mean(4.0, 5.2)); //should return 4.6
        System.out.println(Stats.max(5, 8)); //should return 8
        System.out.println(Stats.max(5.1, 8.1)); //should return 8.1
        System.out.println(Stats.max(-5, -8)); //should return -5
        System.out.println(Stats.max(0, 0)); //should return 0
        System.out.println(Stats.max(0, 8)); //should return 8
        System.out.println(Stats.max(8, 0)); //should return 8
        System.out.println(Stats.max(-8, 8)); //should return 8
        System.out.println(Stats.geoMean(4, 9)); //should return 6
        System.out.println(Stats.geoMean(2.25, 1.69)); //should return 1.95
        System.out.println(Stats.geoMean(-4, -9)); //should return 6
        System.out.println(Stats.geoMean(0, 0)); //should return 0
	System.out.println(Stats.geoMean(0, 1)); //should return 0
        System.out.println(Stats.geoMean(2, 3)); //should return 2
        System.out.println(Stats.max(-8, 8, 2)); //should return 8
        System.out.println(Stats.max(0, 0, 0)); //should return 0
        System.out.println(Stats.max(8.0, 2.1, 9.4)); //should return 9.4
        System.out.println(Stats.max(-4.1, -3.1, -2.9)); //should return -2.9
        System.out.println(Stats.max(1, 1, 1)); //should return 1
        System.out.println(Stats.geoMean(3, 3, 3)); //should return 3
        System.out.println(Stats.geoMean(-3, -3, -3)); //should return -3
        System.out.println(Stats.geoMean(3, -3, -3)); //should return 3
        System.out.println(Stats.geoMean(0, 9, 1)); //should return 0
        System.out.println(Stats.geoMean(1, 8, 27)); //should return 6
        System.out.println(Stats.geoMean(-1, -8, -27)); //should return -6
        System.out.println(Stats.geoMean(1.0, 4.0, 2.0)); //should return 2.0
        System.out.println(Stats.geoMean(0, 1.0, 3.0)); //should return 0.0
    }
}
