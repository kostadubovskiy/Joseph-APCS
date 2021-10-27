/**
Team Sushi plus one (Ruby Friedman, Joseph Othman, Ivina Wang, Ben Belotser)
APCS
HW25 -- Do I repeat myself?
2021-10-26
time spent: 00.5

DISCO:
 * Recursion is when you invoke the same method within itself
 * To use recursion you need a base case and a recursive reduction
   that eventually reaches the base case.
 * The java syntax for recursion is shockingly similiar to that
   for python.
 * If we plug in anything less than 1 in fenceR the code will
   break because it will never reach a base case.

QCC:
 * When should we choose to use recursion as opposed to a loop?
 * How do we avoid the error in discovery #4?

*/
public class Repeater {
    public static String fenceW(int numPosts) {
        String fence = "|";
        int counter = 1;
        while (counter < numPosts){
            fence += "--|";
            counter +=1;
        }
        return fence;
    }
    private static String finalFence = "";
    public static String fenceR(int numPosts) {
        if (numPosts == 1) {
            finalFence = "|";
        }
        else {
            finalFence = fenceR(numPosts - 1);
            finalFence += "--|";
        }
        return finalFence;
    }

    public static void main(String[] args) {
        System.out.println(fenceW(1));
                System.out.println(fenceW(2));
                System.out.println(fenceW(3));

                System.out.println(fenceR(1));
                System.out.println(fenceR(2));
                System.out.println(fenceR(3));
    }
} //end class
