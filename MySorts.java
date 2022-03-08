import java.util.ArrayList;

public class MySorts {

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
 public static void shuffle( ArrayList al )
 {
   int randomIndex;
   //setup for traversal fr right to left
   for( int i = al.size()-1; i > 0; i-- ) {
     //pick an index at random
     randomIndex = (int)( (i+1) * Math.random() );
     //swap the values at position i and randomIndex
     al.set( i, al.set( randomIndex, al.get(i) ) );
   }
 }


  public static void bubbleSortV( ArrayList<Comparable> data )
    {
      int bubblecount=0;
      for (int i = 0; i < data.size() - 1; i ++) {
        int swaps = 0;
          for (int j = data.size() - 1; j > i; j --) {
              Comparable leftVal = data.get(j - 1);
              Comparable rightVal = data.get(j);
              bubblecount++;
              if (leftVal.compareTo(rightVal) > 0) {
                  swaps += 1;
                  data.set(j, leftVal);
                  data.set(j - 1, rightVal);
              }
          }
          if (swaps == 0) {
            break;
          }
      }
      System.out.println("Number of comparisons: " + bubblecount);
  }


  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubble( ArrayList<Comparable> input )
  {
    ArrayList<Comparable> newData = new ArrayList<Comparable>();
    for(Comparable c: input) {
        newData.add(c);
    }
    bubbleSortV(newData);
    return newData;
  }

    public static void selectionSortV( ArrayList<Comparable> data )
  {
    int selectcount=0;
    //note: this version places greatest value at "rightmost" end

    //maxPos will point to position of SELECTION (greatest value)
    int maxPos;

    for(int pass = data.size() - 1; pass > -1; pass-- ) {
      // System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
      maxPos = pass;

      for(int i = 0; i < pass; i++  ) {
        Comparable p1 = data.get(maxPos);
        Comparable p2 = data.get(i);
        selectcount++;
        if(p1.compareTo(p2) < 0) {
          maxPos = i;
        }
      }

      Comparable p3 = data.get(maxPos);
      Comparable p4 = data.get(pass);
      // System.out.println( "maxPos: " + maxPos );//diag
      // System.out.println( data );//diag
      data.set(pass, p3);
      data.set(maxPos, p4);


      // System.out.println( "after swap: " +  data );//diag
      }
    System.out.println("Number of comparisons: " + selectcount);



  }


  // ArrayList-returning selectionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> selection( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    selectionSortV( data );

    return data;
  }

  public static void insertionSortV( ArrayList<Comparable> data )
  {
    int insertcount=0;
    for(int partition=1; partition<data.size(); partition++  ) {
      //partition marks first item in unsorted region

      // System.out.println( "\npartition: " + partition + "\tdataset:"); //diag
      // System.out.println( data );

      //traverse sorted region from right to left
      for(int i=partition; i>0; i--) {

        // "walk" the current item to where it belongs
        // by swapping adjacent items
        Comparable p1 = data.get(i);
        Comparable p2 = data.get(i-1);
        insertcount++;
        if (p2.compareTo(p1)>0  ) {


          // System.out.println( "swap indices "+(i-1)+" & "+i+"..." ); //diag
          data.set(i,p2);
          data.set(i-1,p1);
        }
        else
          break;
      }
    }
    System.out.println("Number of comparisons: " + insertcount);
  }


  // ArrayList-returning insertionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> insertion( ArrayList<Comparable> input )
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
  }

}
