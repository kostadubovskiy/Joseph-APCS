/**
Team PJOLLN: Neil Lin, Lior Polischouk, Joseph Othman
APCS pd7
HW77 -- Insert|Remove
2022-03-15
time spent: 0.5 h
KTS Used: 2

DISCO:
- New add and rem are both O(n), since we need to traverse through the array until
  we can modify the LL.
- Our add algo doesn't work for index = 0, i.e. when we want to append at the start.
  To deal with this, we just called the original add method.


QCC:
- Why add on left side of LL?
- More efficient way to do this other than traverse until correct spot?
  - add and rem both O(n) time because we need to traverse all the way up.


ALGO ADD:
- Create a new node with parameters (newVal, null).
- Traverse through existing LL until reach the node at index (i-1).
- setNext of the new Node to be the node currently at index i.
- setNext of the node currently at index (i-1) to be the new node.
- increase the size accordingly.


ALGO REM:
- Traverse through the LL until we reach the node at index (i-1).
- Create a temp storge node of the node currently at index i.
- setNext of the node at index (i-1) to be the node currently at index (i+1).
- decrease the size accordingly.
- return the cargo of the temp storage node.

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
    _head = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    LLNode tmp = new LLNode( newVal, _head );
    _head = tmp;
    _size++;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    String retVal;
    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }

  public void add( int index, String newVal )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    if ( index == 0 ) {
      add(newVal);
      _size--; // cancel the _size++ that occurs in the original add method.
    }
    else {
      LLNode newNode = new LLNode(newVal, null);
      LLNode tmp = _head;
      int indCtr = 0;
      while(indCtr < index - 1) {
        indCtr++;
        tmp = tmp.getNext();
      } // Now, tmp points to the node with index (i-1).

      newNode.setNext(tmp.getNext()); //newNode CDR points to node that will follow it in the new LL.
      tmp.setNext(newNode); //connect the node at index i - 1 to the newNode, making the new node at index i.
    }
    _size++; //increase the size.

  }

  public String remove( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    int indCtr = 0;
    LLNode tmp = _head;
    while(indCtr < index -1) {
      indCtr++;
      tmp = tmp.getNext();
    } //tmp points to node at index i-1, the one before the node that will get removed.

    LLNode oldNode = tmp.getNext(); //You will be forgotten, loved one.
    tmp.setNext(oldNode.getNext());
    _size--;
    return oldNode.getCargo();

  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() ) {
      throw new IndexOutOfBoundsException();
    }

    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //store target node's cargo
    String oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    LLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
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
    System.out.println( james._size );

    james.add(0,"wee");
    System.out.println("add 'wee' at index 0:");
    System.out.println(james);
    System.out.println( "size: " + james.size() );

    james.add(4,"woo");
    System.out.println("add 'woo' at index 4:");
    System.out.println(james);
    System.out.println( "size: " + james.size() );

    james.remove(2);
    System.out.println("remove at index 2:");
    System.out.println(james);
    System.out.println( "size: " + james.size() );


  }

}//end class LList
