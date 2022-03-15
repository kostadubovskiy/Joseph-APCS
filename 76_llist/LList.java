/**
Team PJOLLN: Neil Lin, Lior Polischouk, Joseph Othman
APCS pd7
HW76 -- We Got a Little Ol' Convoy
2022-03-14
time spent: 0.8 h
KTS Used: 2

*/


/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {

  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    LLNode newNode = new LLNode(newVal, null);
    if(_head == null) {
      _head = newNode;
    }
    else {
      LLNode temp = _head;
      while(temp.getNext() != null) {
        temp = temp.getNext();
      }
      temp.setNext(newNode);
    }
    _size +=1;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    // YOUR CODE HERE
    LLNode temp = _head;
    int indCounter = 0;
    while(indCounter < index) {
      indCounter += 1;
      temp = temp.getNext();
    }
    return temp.getCargo();
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    // YOUR CODE HERE
    LLNode temp = _head;
    int indCounter = 0;
    while(indCounter < index) {
      indCounter += 1;
      temp = temp.getNext();
    }
    _size +=1;
    String oldVal = temp.getCargo();
    temp.setCargo(newVal);
    return oldVal;
  }


  //return number of nodes in list
  public int size()
  {
    return _size;
  }

  //--------------^  List interface methods  ^--------------



  // override inherited toString
  public String toString()
  {
    String ans = "";
    LLNode temp = _head;
    while(temp != null) {
      ans+= temp.getCargo() + " ";
      temp= temp.getNext();
    }
    return ans;
  }


  //main method for testing
  public static void main( String[] args )
  {
    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println( james );
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class LList
