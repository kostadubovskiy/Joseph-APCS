import java.util.ArrayList;

public class OrderedArrayList
{

  // instance of class ArrayList, holding objects of type Integer
  // (i.e., objects of a class that implements interface Integer)
  private ArrayList<Integer> _data;

  // default constructor
  // initializes instance variables
  public OrderedArrayList()
  {
    _data = new ArrayList<Integer>(); // empty constructor means inital capacity of 10
  }

  public String toString()
  {
    return _data.toString();
  }

  /*
  public Integer remove(int i)

  Best case: O(1)
  Why?
  Similar to the normal ArrayList, removing the last element in the ArrayList
  requires clearing that entry and no other moves (i.e. no shifting parts of the
  ArrayList). This is not depenedent on the length of the ArrayList, so this occurs
  in O(1) time.

  Worst case: O(n)
  Why?
  In order to remove the first element, we must shift all elements over by 1
  index. This is done in O(n) time since we must traverse the entire array once,
  performing one shift each time.

  */

  public Integer remove( int i )
  {
    Integer oldVal = _data.get(i);
    _data.remove(i);
    return oldVal;
  }

  /* public int size()

  Only case: O(1) time.
  Why?
  This method is just returning an already stored variable, which has no dependence
  on the length of the array.

  */
  public int size()
  {
    return _data.size();
  }

  /*
  public Integer get( int i )

  All cases: O(1) time
  Why?
  Because of the way the memory is allocated for an ArrayList (i.e. it is all in one
  connected spot), each of the elements is available to the machine after 1 step.
  Then, we simply return this desired element. This gives O(1) time,
  */

  public Integer get( int i )
  {
    return _data.get(i);
  }

  // inserts newVal at the appropriate index
  // maintains ascending order of elements
  // uses a linear search to find appropriate index

    /*
    Best case: O(1) time.
    Why?
    When we are inserting an element, there is the case where the element is larger
    than all others already in the arraylist. In order to append this element, this will
    perform one comparison between the input and the rightmost element. Then, it will
    append the input at the end. This is constant, no matter how long the arraylist is.

    Worst case: O(n) time.
    Why?
    When the input object is "smaller" than all elements in the already existing arraylist,
    then in order to add the element and keep the array sorted, we must find where to find
    the correct index of this element by performing n comparisons, and then adding the
    input element at the beginning.
    */
  public void addLinear(Integer newVal)
  {
    boolean skip = false;
    int N = _data.size();
    for (int i = 0; i < N; i++) {
        if (_data.get(i) >= newVal) {
            _data.add(i, newVal);
            skip = true;
            break;
        }
    }
    if (skip == false) {
        _data.add(newVal);
    }
  }

  // main method solely for testing purposes
  public static void main( String[] args )
  {

    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
      Franz.addLinear( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

    /*-----v-------move-me-down-----------------v--------*/

    // testing binary search
    // Franz = new OrderedArrayList();
    // for( int i = 0; i < 15; i++ )
    //   Franz.addBinary( (int)( 50 * Math.random() ) ); // removed because addBinary did not work :(.
    //
    // System.out.println( Franz );


      /*=====^====================================^=========*/

  }//end main()

}//end class OrderedArrayList
