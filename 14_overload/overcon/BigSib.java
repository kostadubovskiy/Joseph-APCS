/*
Joseph, Kosta, Po, Davie
APCS
HW12 -- On Elder Individuality and the Elimination of Radio Fuzz
2021-10-05
*/

public class BigSib {
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
DISCO and QCC on other file.
*/
