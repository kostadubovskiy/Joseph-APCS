// Team PJOLLN: Neil Lin, Lior Polischouk, Joseph Othman
// APCS pd7
// HW72 -- So So Fast (Using Partition to find yth smallest element)
// 2022-03-07m
// time spent: 0.5 hrs

/**
ALGO:
Recursively shrink the array that we're looking in until the array becomes
length 1, in which case sorted and we've found our desired element. To do this,
take a = lo, b = hi-1, c = hi-1 (the last element in the array we are searching),
and run the method. Then, compare the index, x of the final resting place of the pivot
and y-1; if x > y - 1, then restrict the search array to the left partition of the
array. if x < y - 1, then restrict the search array to the right partition of the
array. If x = y - 1, we have won.

Best Case Scenario:
The element we choose as the pivot is the same as the yth smallest element. Then,
after 1 pass of the partition method, we have found the desired element. This will
occur in O(n) runtime.

Worst Case Scenario:
All worst case scenarios are of the form: one side of the partition 1, and the other
side of the partition is "big," and it takes very long until we get to the yth smallest
element. Example: elements are already sorted, and we start from the end; we want the
smallest element (y=1). This will require n-1 passes, each pass shrinking the subarray
we are checking by 1 element. Since each pass runs the partition method, which itself
runs in O(n) time, this will run in O(n^2) time.

DISCO:
The partition method returning the index was a blessing, as it was the only way to
relate information between the past runs and the next ones. However, it did confuse
us initially when trying to write code: how do we know what ACTUALLY happened to the
array? Resolution: in line print statements. Also, review pass by value and pass by
reference concepts.

QCC:
The worst possible runtime of this algorithm is O(n^2). Amoritized, it is O(nlogn).
What makes this better than just running a mergesort and taking the yth smallest
element from the sorted list?


*/



public class QuickSelect {

  // Helper methods copied from yesterday's hw
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  public static int partition( int arr[], int a, int b, int c)
    {
      int v = arr[c];

      swap( c, b, arr);
      int s = a;

      for( int i = a; i < b; i++ ) {
        if ( arr[i] <= v) {
          swap( i, s, arr );
          s++;}
      }
      swap(s,b,arr);

      return s;
    }//end partition

  public static int ythSmallest( int arr[], int y)
    {
      int lo = 0;
      int hi = arr.length - 1;
      int pvtInd = arr.length - 1;
      int s = -1;
      while(s != y-1) {
        s = partition(arr, lo, hi, pvtInd);
        if(s > y-1) {
          hi = s-1;
          pvtInd = hi;
        }
        else {
          lo = s+1;
        }
      }
      //printArr(arr); //Uncomment to print the array in order to see final array: helped with debugging.
      return arr[s];
    }// end ythSmallest

  public static void main( String[] args )
  {

    for( int testY = 1; testY <= 5; testY++ ) {
      int[] arr1 = {8,21,17,69,343}; // this is here in order to reset the array each time.
      System.out.println("arr1: ");
      printArr(arr1);
      System.out.println(testY + "th smallest element:");
      System.out.println( ythSmallest(arr1,testY) );
      System.out.println("-----------------------");
    }

    for( int testY = 1; testY <= 5; testY++) {
      int[] arr3 = {1,28,33,4982,37};
      System.out.println("arr3: ");
      printArr(arr3);
      System.out.println(testY + "th smallest element:");
      System.out.println( ythSmallest(arr3,testY) );
      System.out.println("-----------------------");
    }

    for( int testY = 1; testY <= 5; testY++) {
      int[] arr4 = {5,4,17,9000,6};
      System.out.println("arr4: ");
      printArr(arr4);
      System.out.println(testY + "th smallest element:");
      System.out.println( ythSmallest(arr4,testY) );
      System.out.println("-----------------------");
    }

    for( int testY = 1; testY <= 5; testY++) {
      int[] arr5 = {3,0,16,599,1024};
      System.out.println("arr5: ");
      printArr(arr5);
      System.out.println(testY + "th smallest element:");
      System.out.println( ythSmallest(arr5,testY) );
      System.out.println("-----------------------");
    }

  } // end main
}//end FastSelect class
