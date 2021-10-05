public class Greet {
  public static void main( String[] args ) {
    String greeting0;
    String greeting1;
    String greeting2;
    String greeting3;

    BigSib richard = new BigSib();
    richard.setHelloMsg("Word up");

    greeting0 = richard.greet("freshman");
    System.out.println(greeting0);

    BigSib julia = new BigSib();
    julia.setHelloMsg("Salutations");

    greeting1 = julia.greet("Dr. Spaceman");
    System.out.println(greeting1);

    BigSib john = new BigSib();
    john.setHelloMsg("Hey ya");

    greeting2 = john.greet("Kong Fooey");
    System.out.println(greeting2);

    BigSib jacob = new BigSib();
    jacob.setHelloMsg("Sup");

    greeting3 = jacob.greet("mom");
    System.out.println(greeting3);



  } //end main()
} //end Greet
