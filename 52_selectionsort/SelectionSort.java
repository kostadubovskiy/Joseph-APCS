// Clyde "Thluffy" Sinclair
// APCS pd0
// HW52 -- implementing selection sort
// 2022-01-05w
// time spent:  hrs

/******************************
 *   class SelectionSort -- implements SelectionSort algorithm
 *
 * ALGO:
 * Find the maximum of all elements, and swap this with the element currently
 at the end of the ArrayList. Then find the largest of all elements to the left
 of the elements that have been swapped, and swap it with the rightmost element
 of those that are not confirmed to be in the correct spot (an element is confirmed
 to be in the right spot if its distance from the rightmost element is < the pass number
 after the pass is completed (this distance includes the element itself)).
 * DISCO
 * In terms of number of passes, SelectionSort has no best case.
 * Relative to the size of the ArrayList (size n), this sorting algorithm takes
 exactly n(n-1)/2 "checks" to sort the ArrayList.
 * QCC
 * q0: How many passes to sort n elements?
 * a0: It takes n passes to sort n elements (n-1 if we use process of elimination).
 * q1: What do you know after pass p?
 * a1: The last p elements in the ArrayList are sorted.
 * q2: How do you know if sorted?
 * a2: We don't know until all n passes are complete.
 * q3: What does a pass boil down to?
 * a3: At pass p, find the maximum of all elements to the left of index n-p (where
 n is the ArrayList size), and swap this element with the element currently index
 n - p - 1.
 * q4: Can we do better than n(n-1)/2 checks in order to sort the ArrayList?
 ******************************/


import java.util.ArrayList;

public class SelectionSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi )
  {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSortV( ArrayList<Comparable> data )
  {
    //note: this version places greatest value at "rightmost" end

    //maxPos will point to position of SELECTION (greatest value)
    int maxPos;

    for(int pass = data.size() - 1; pass > -1; pass-- ) {
      System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
      maxPos = pass;

      for(int i = 0; i < pass; i++  ) {
        Comparable p1 = data.get(maxPos);
        Comparable p2 = data.get(i);
        if(p1.compareTo(p2) < 0) {
          maxPos = i;
        }
      }

      Comparable p3 = data.get(maxPos);
      Comparable p4 = data.get(pass);
      System.out.println( "maxPos: " + maxPos );//diag
      System.out.println( data );//diag
      data.set(pass, p3);
      data.set(maxPos, p4);


      System.out.println( "after swap: " +  data );//diag
      }



  }//end selectionSort


  // ArrayList-returning selectionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    selectionSortV( data );

    return data;
  }//end selectionSort


  public static void main( String [] args ) {


    /*===============for VOID methods=============
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      selectionSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      selectionSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );
    ============================================*/

    /*==========for AL-returning methods==========*/
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = selectionSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n"
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = selectionSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
    /*============================================*/

  }//end main

}//end class SelectionSort
