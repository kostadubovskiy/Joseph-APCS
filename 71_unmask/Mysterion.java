// Pautrio: Oscar Breen, Lindsay Phung, Joseph Othman
// APCS pd7
// HW71 -- Reading for intent, tracing for VICTORY
// 2022-03-07m
// time spent: 0.5 hrs

/***
 * SKEELTON for
 * class Mysterion
 * tests preliminary hypotheses re: utility of mystery algo
 *
 * <h1>It's a Bird, It's a Plane! It's.... MYSTERION</h1>
 * The Mysterion method ... <YOUR TRIO'S DESCRIPTION HERE>
 * <p>
 * <b>Note:</b> BLAH blah blah, yakkety schmakketty...
 * @author  Trey Parker, Matt Stone
 * @version 3.1415926535897932384626433
 * @since   2022-03-07m
 *
 * algo as pseudocode:
 * ------------------------------
 *     v = arr[c]
 *     swap arr[c], arr[b]
 *     s = a
 *     for i in [a..b-1]
 *         if arr[i] < v
 *             swap arr[s], arr[i]
 *             s+=1
 *     swap arr[b], arr[s]
 *
 * DISCO
 *  After running Mysterion over all possible choices of c within the array, we eventually get
      a sorted array.
    The partition idea reminds us of insertion sort; could this be used for a sorting algo?
      If so, we might apply a recursive divide and conquer similar to merge sort. Don't see
      exactly how to do this yet though.
 * QCC
 *  Can we do better than testing each element as a "center?"
    How to choose a, b, and c "optimally?"
 * q0: What does it do?
 * a0: Chooses an element as the "center," then partitions the subarray from index a to index b-1
 into 2 groups; on the left, the elements are less than the center, and the right consists of
 elements at least the center. Then places the center element between the two parts of the subarray.
 *
 * q1: O(?)
 * a1: Mysterion's worst case scenario is O(n) runtime; this occurs when a = 0 and b = arr.length - 1,
 and c = index of the minimum element (this implies that each iteration in the loop leads to 1 swap).
 *
 ***/


public class Mysterion
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d )
  {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------


  /**
   * int mysterion(int[],int,int,int)
   * DESCRIP
   * chooses an element as a "center" (don't know actual terminology), and works around that
    moves that center to index b, and then partitions subarray between indicies a and b-1
    into 2 parts: the part that consists of elemets that are smaller than the center element
    (on the left) and the part that consists of elements that are at least as large as the
    center element (on the right). Then, puts the center element between the 2 parts.
   * @param arr
   * @param a
   * @param b
   * @param c
   * @return int
   *
   */
  public static int mysterion( int arr[], int a, int b, int c)
  {
    /** Copy and Pasted for convenience
    * algo as pseudocode:
    * ------------------------------
    *     v = arr[c]
    *     swap arr[c], arr[b]
    *     s = a
    *     for i in [a..b-1]
    *         if arr[i] < v
    *             swap arr[s], arr[i]
    *             s+=1
    *     swap arr[b], arr[s]
    */
    int v = arr[c]; // CHOOSE THE CENTER ELEMENT
    swap(c,b,arr); // SWAP CENTER ELEMENT TO END OF SUBARRAY
    int s=a;
    for(int i = a; i < b; i++) { //PERFORM SWAPS UNTIL THE ARRAY IS PARTITIONED INTO THE AFOREMENTIONED PARTS
      if (arr[i] < v) {
        swap(s,i,arr);
        s+=1; // MOVES THE LINE OF DIVISION BETWEEN THE TWO PARTS OF THE SUBARRAY
      }
    }
    swap(b,s,arr); // PLACES CENTER ELEMENT AT THE END OF THE FIRST PART OF THE SUBARRAY
    return arr[s];
  }//end mysterion


  //main method for testing
  public static void main( String[] args )
  {


    //init test arrays of magic numbers
    int[] arr1 = {8,21,17,69,343};
    int[] arr3 = {1,28,33,4982,37};
    int[] arr4 = {5,4,17,9000,6};
    int[] arr5 = {3,0,16,599,1024};
    int[] arr6 = {7,1,5,12,3};

    /**
    System.out.println("arr6: ");
    printArr(arr6);
    mysterion(arr6,0,4,2);
    System.out.println("after mysterion w/ a=0,b=4,c="
    + 2 +"...");
    printArr(arr6);
    System.out.println("-----------------------");
    */

    // run mysterion on each array,
    // holding a & b fixed, varying c...
    for( int testC = 0; testC < 5; testC++ ) {
    System.out.println("arr1: ");
    printArr(arr1);
    mysterion(arr1,0,4,testC);
    System.out.println("after mysterion w/ a=0,b=4,c="
    + testC +"...");
    printArr(arr1);
    System.out.println("-----------------------");

    // Where be arr2?

    System.out.println("arr3:");
    printArr(arr3);
    mysterion(arr3,0,4,testC);
    System.out.println("after mysterion w/ a=0,b=4,c="
    + testC +"...");
    printArr(arr3);
    System.out.println("-----------------------");

    System.out.println("arr4:");
    printArr(arr4);
    mysterion(arr4,0,4,testC);
    System.out.println("after mysterion w/ a=0,b=4,c="
    + testC +"...");
    printArr(arr4);
    System.out.println("-----------------------");

    System.out.println("arr5:");
    printArr(arr5);
    mysterion(arr5,0,4,testC);
    System.out.println("after mysterion w/ a=0,b=4,c="
    + testC +"...");
    printArr(arr5);
    System.out.println("-----------------------");
    }
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main

}//end class Mysterion
