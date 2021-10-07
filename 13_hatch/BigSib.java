/*
Joseph, Kosta, Po, Davie
APCS
HW12 -- On Elder Individuality and the Elimination of Radio Fuzz
2021-10-05
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
- You can set a variable, and then use a function to set the value of that variable.
- You can use the BigSib richard = new BigSib(); syntax to run BigSib functions with different inputs as much as you want.
QCC
- What allows a function to set the value of a variable that isn't an input of the function?
- Why would we use this syntax instead of other types?
*/
