/*
TNPG: Pseb & Co (Andrew Piatesky, Paul Serbanescu, Joseph Othman) and Burnt Peanut
APCS
HW43 - Array of Steel
2021-12-06
time spent: 25min
DISCOVERIES:
One way to modify arrays is by using a temporary storage array and to "dump" all
of the info from our previously existing array into it, then to make a new array
with the same name as the initial array (in our case, _data) and to make the
necessary changes when we initialize _data.
QUESTIONS:
What would be the best implementations of append and remove? Should we remove at
any given index? Should we append any value, and where?
Is there any built in functionality that will allow us to have these array
functions?
*/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    this._data = new int[10];
    this._size = 10;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String x = "";
    x = x + "[";
    for(int i = 0; i< _data.length-1; i++) {
      x = x + _data[i] + ",";
    }
    x = x + _data[_data.length-1];
    x = x + "]";
    return x;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] _temp = new int[this._size];
    int _oldSize = this._size;
    for(int i = 0; i < _size; i++) {
      _temp[i] = _data[i];
    }

    this._size *= 2;
    _data = new int[this._size];

    for(int i = 0; i < _oldSize; i++) {
      _data[i] = _temp[i];
    }
  }


  //accessor -- return value at specified index
  public int get( int index ){
      return this._data[index];
  }


  //mutator -- set value at index to newVal,
  //return old value at index
  public int set( int index, int newVal )
  {
    int _temp = get(index);
    _data[index] = newVal;
    return _temp;
  }

  //append -- add an element to the end of the
  //array, with value newVal.
  public void append(int newVal) {
      int[] _temp = new int[this._size];
      int _oldSize = this._size;
      for(int i = 0; i < _size; i++) {
        _temp[i] = _data[i];
      }

      this._size +=1;
      _data = new int[this._size];

      for(int i = 0; i < _oldSize; i++) {
        _data[i] = _temp[i];
      }
      _data[_oldSize] = newVal;
  }

  //remove -- remove an element with the specified
  //index. PRECOND: input is an integer between 0
  //and this._size-1, inclusive.
  public void remove(int index) {
    int[] _temp = new int[this._size];
    int _oldSize = this._size;
    for(int i = 0; i < _size; i++) {
      _temp[i] = _data[i];
    }

    this._size -=1;
    _data = new int[this._size];

    for(int i = 0; i < index; i++) {
      _data[i] = _temp[i];
    }
    for(int j = index + 1; j< _oldSize; j++) {
      _data[j-1] = _temp[j];
    }
  }


  //main method for testing
  public static void main( String[] args )
  {
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );

      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }
      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);
      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      for( int j = 0; j < curtis._data.length; j++ ) {
      curtis.set( j, j * 2 );
      }
      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);
      }
      curtis.append(1);
      System.out.println("Printing appended SuperArray curtis...");
      System.out.println(curtis);
      curtis.remove(8);
      System.out.println("Printing SuperArray curtis with index 8 removed...");
      System.out.println(curtis);

      /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class
