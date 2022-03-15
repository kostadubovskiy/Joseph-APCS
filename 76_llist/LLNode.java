/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode
{
  //instance vars
  private String element;
  private LLNode nextNode;

  // constructor
  public LLNode( String value, LLNode next )
  {
    element = value;
    nextNode = next;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return element;
  }

  public LLNode getNext()
  {
    return nextNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    element = newCargo;
    return element;
  }

  public LLNode setNext( LLNode newNext )
  {
    nextNode = newNext;
    return nextNode;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    return (element);
  }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    LLNode first = new LLNode( "cat", null );
    System.out.println(first);
    //Create a new node after the first
    first.setNext( new LLNode( "dog", null ) );
    System.out.println(first.nextNode);
    //Create a third node after the second
    first.getNext().setNext( new LLNode( "cow", null ) );
    System.out.println(first.nextNode.nextNode);

    /* A naive list traversal, has side effects.... ??
       while( first != null ) {
       System.out.println( first );
       first = first.getNext();
       }
    */

    //Q: when head ptr moves to next node in list, what happens to the node it just left?
    // The information about what that node was is lost.
    //...so better: ?
    // Not with our current implementation. Maybe class List will shed some light...
    //
    //

  }//end main

}//end class LLNode
