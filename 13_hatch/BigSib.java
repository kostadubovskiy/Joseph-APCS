/*
Joseph, Kosta, Po, Davie
APCS
HW13 -- Where do Big Sibs Come From?
2021-10-06
*/

public class BigSib {
	public BigSib(String k) {
		HelloMsg = k;
	}

	public static void main (String[] args){
		System.out.println(greet("Flam"));
	}

	public static String HelloMsg;

	public static String setHelloMsg(String x) {
		HelloMsg = x;
		return HelloMsg;
	}


	public static String greet(String x) {
		return HelloMsg + " " + x;
	}


}


/*
DISCO
- When we use the "BigSib richard = new BigSib()" syntax, we can acutally  give inputs to the instance of BigSib (called richard) within the parenthesis, which the constructor will use in its code.
- We postulate that the constructor needs the same name as the class because when we use the new instance syntax, we write new BigSib(). possibly with parameters. The constructor must be named BigSib or else it will not be run.

QCC
- What happens if there is more than one input? Should they be ordered a certain way?
- Why use constructors to initialize variables? Does it provide a functional use that we haven't had before?
- Can the constructor initiate more than one variable? What is the syntax, if it can?
- Can you have more than one constructor in a class?
*/
