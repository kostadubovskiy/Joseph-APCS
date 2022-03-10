//Team PJOLLN: Neil Lin, Lior Polischouk, Joseph Othman
//APCS pd7
//HW73 -- QuickSort
//2022-03-09w
//time spent: 0.5 h

/***
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): Take arr, and perform a partition, choosing the pivot by taking
 the median of 3 randomly chosen entries of the array.
 Then, QSort on the left and right partitions of the current array. Continue until
 done.

 Why we choose the median of 3 random entries of the array:
 This is not deterministic, so it will not ALWAYS be bad for an array, and choosing
 the median of the three means that we'll be less likely to be near the extremes).
 *
 * 2a. Worst pivot choice and associated run time:
 * Minimum or maximum element. O(n^2).
 * 2b. Best pivot choice and associated run time:
 * Median element. O(nlogn).
 * 3. Approach to handling duplicate values in array:
 *  Throw in a less than or equal to instead of a less than witihin the partition
 method.
 **/

public class QuickSort
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
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   */
  public static void qsort( int[] d )
  {
    qsort(d, 0, d.length - 1);
  }

  //you may need a helper method...

  public static void qsort( int[] d, int loPos, int hiPos)
  {
    if(loPos > -1 && hiPos < d.length && loPos < hiPos)
    {
      int x = partition(d, loPos, hiPos);
      qsort(d, loPos, x-1); //qsort on the left partition
      qsort(d, x+1, hiPos); //qsort on the right partition
    }
  }

  public static int partition( int arr[], int loPos, int hiPos)
  {
    int pvtPos;
    // Let's choose 3 elements and take their median. This will correspond to the pivot element.
    // This helps in avoiding the worst case, most of the time; this is not deterministic, so
    // On average this works pretty fast.

    int x = loPos + (int) (Math.random()*(hiPos-loPos+1));
    int y = loPos + (int) (Math.random()*(hiPos-loPos+1));
    int z = loPos + (int) (Math.random()*(hiPos-loPos+1));

    if((x < y && y < z) || (x > y && y > z)) {
      pvtPos = y;
    }

    else if ((x < z && z < y) || (x > z && z > y)) {
      pvtPos = z;
    }

    else {
      pvtPos = x;
    }

    int v = arr[pvtPos];

    swap( pvtPos, hiPos, arr);
    int s = loPos;

    for( int i = loPos; i < hiPos; i++ ) {
      if ( arr[i] <= v) {
        swap( i, s, arr );
        s++;}
    }
    swap(s,hiPos,arr);

    return s;
  }//end partition





  //main method for testing
  public static void main( String[] args )
  {

    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );

    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
