public class Greet {
  public static void main( String[] args ) {
    String greeting0;
    String greeting1;
    String greeting2;
    String greeting3;

    BigSib julia = new BigSib("Word up");

    greeting0 = julia.greet("freshman");
    System.out.println(greeting0);

    BigSib jacob = new BigSib("Salutations");

    greeting1 = jacob.greet("Dr. Spaceman");
    System.out.println(greeting1);

    BigSib john = new BigSib("Hey ya");

    greeting2 = john.greet("Kong Fooey");
    System.out.println(greeting2);

    BigSib josiah = new BigSib("Sup");

    greeting3 = josiah.greet("mom");
    System.out.println(greeting3);




  } //end main()
} //end Greet
