// Fred Gang: Joseph Othman, Michael Kamela, Lawrence Joa
// APCS pd07
// HW52 -- implementing selection sort
// 2022-01-05w
// time spent:  0.3hrs

/******************************
 * class InsertionSort -- implements InsertionSort algorithm
 *
 * ALGO:
 We will run n-1 passes. At the ith pass, take the element in position i (starting
 at when i = 1) and swap it to the left, continuously doing so until this element is
 at least as large as the one to its left. Continue this until we have a completely
 sorted ArrayList.
 *
 * DISCO
 As with BubbleSort and SelectionSort, this algorithm requires at most n(n-1)/2
 "checks" to complete the sort.
 The best case scenario for InsertionSort is when all elements are already sorted,
 as then the algo only performs n-1 comparisons and no swaps.
 The worst case scenario is when elements are in reverse order, as this will require
 a comparison between every possible pair of elements, giving n(n-1)/2 total checks.
 *
 * QCC
 * q0: How many passes to sort n elements?
 * a0: We need n-1 passes to sort n elements.
 * q1: What do you know after pass p?
 * a1: The first p elements form a sorted subArrayList.
 * q2: How will you know when sorted?
 * a2: After the (n-1)-th pass then the ArrayList is certainly sorted.
 * q3: What constitues a pass?
 * a3: Take the element at index i, then swap it to the left until our element
 is at least as large as the one to its left.
 * q4: What must you track?
 * a4:
 ******************************/


import java.util.ArrayList;

public class InsertionSort
{
  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void insertionSortV( ArrayList<Comparable> data )
  {
    for(int partition=1; partition<data.size(); partition++  ) {
      //partition marks first item in unsorted region

      System.out.println( "\npartition: " + partition + "\tdataset:"); //diag
      System.out.println( data );

      //traverse sorted region from right to left
      for(int i=partition; i>0; i--) {

        // "walk" the current item to where it belongs
        // by swapping adjacent items
        Comparable p1 = data.get(i);
        Comparable p2 = data.get(i-1);
        if (p2.compareTo(p1)>0  ) {


          System.out.println( "swap indices "+(i-1)+" & "+i+"..." ); //diag
          data.set(i,p2);
          data.set(i-1,p1);
        }
        else
          break;
      }
    }
  }//end insertionSortV


  // ArrayList-returning insertionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable>
    insertionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    insertionSortV( data );

    //return working ArrayList
    return data;
  }//end insertionSort


  public static void main( String [] args )
  {
      /*===============for VOID methods=============
      System.out.println("\n*** Testing sort-in-place (void) version... *** ");
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "\nArrayList glen before sorting:\n" + glen );
      insertionSortV(glen);
      System.out.println( "\nArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      insertionSortV(coco);
      System.out.println( "\nArrayList coco after sorting:\n" + coco );
      ============================================*/

      System.out.println( "*** Testing non-void version... *** " );
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "\nArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = insertionSort( glen );
      System.out.println( "\nsorted version of ArrayList glen:\n"
      + glenSorted );
      System.out.println( "\nArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = insertionSort( coco );
      System.out.println( "\nsorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "\nArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
      /*==========for AL-returning methods==========
      ============================================*/

  }//end main

}//end class InsertionSort
