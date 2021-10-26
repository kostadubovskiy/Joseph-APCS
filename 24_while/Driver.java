/***
    driver for class Coin
    ~~~ SUGGESTED WORKFLOW: ~~~
    1. Compile this file and run. Note anything notable.
    2. Move the "TOP" line down, so that it is below the first statement.
    (emacs: with cursor at beginning of TOP line, C-k C-k, DOWN, DOWN, C-y)
    (your editor: ???)
    3. Compile and run again.
    4. Resolve errors one at a time until it works.
    5. Repeat 2-4 until TOP meets BOTTOM.
***/

public class Driver {

    public static void main( String[] args ) {
  
      //build Objects from blueprint specified by class Coin
  
  
      //test default constructor
        Coin mine = new Coin();
        //test 1st overloaded constructor
        Coin yours = new Coin( "quarter" );
        //test 2nd overloaded constructor
        Coin wayne = new Coin( "dollar", "heads" );
        //test toString() methods of each Coin
        System.out.println("mine: " + mine);
        
        System.out.println("yours: " + yours);
        
        System.out.println("wayne: " + wayne);
        //test flip() method
        System.out.println("\nAfter flipping...");
        yours.flip();
        wayne.flip();
        System.out.println("yours: " + yours);
        System.out.println("wayne: " + wayne);
        //test equals() method
        if ( yours.equals(wayne) ) {
          System.out.println( "Matchee matchee!" );
        }
        else {
          System.out.println( "No match. Firestarter you can not be." );
        }
        
        //10-25-2021 CW
        int locHeadsCtr = 0;
        int x = 16;
        int flips = 0;
        Coin joseph = new Coin("penny");
        while (locHeadsCtr < x) {
        	if (joseph.flip() == "heads") {
        		locHeadsCtr += 1;
        	}
        	flips += 1;
        }
        
        System.out.println(locHeadsCtr);
        System.out.println(flips);
        
        Coin kosta = new Coin("dollar");
        int y = 16;
        int locMatchCtr = 0;
        int flipCycles = 0;
        
        while (locMatchCtr < y) {
        	if (joseph.flip() == kosta.flip()) {
        		locMatchCtr += 1;
        	}
        	
        	flipCycles += 1;
        }
        
        System.out.println(locMatchCtr);
        System.out.println(flipCycles);
        
        int z = 65536;
        locMatchCtr = 0;
        flipCycles = 0;
        
        while (true) {
        	if (joseph.flip() == kosta.flip()) {
        		locMatchCtr += 1;
        	}
        	
        	flipCycles += 1;
        	
        	if (locMatchCtr >= z && locMatchCtr % 2005 == 0) {
        		break;
        	}	
        }
        
        System.out.println(locMatchCtr);
        System.out.println(flipCycles);
        
        
        /*===================TOP==========================
        ====================BOTTOM======================*/
  
    }//end main()
  
  }//end class
  
