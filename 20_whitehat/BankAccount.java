/*
Triumphant Triumvirate: Salaj Rijal: George, Ariel Fuchs: Skelly Ducky, Ben Belotser: TwoFace
APCS
HW 19 -- Mo Money Mo Problems... MORE AWESOME -- Creating authenticate() with the help of conditionals
2021-10-18
DISCO:
-Structure of conditional in java:
if (boolean){
	//Actions taken if boolean true
}
else if (boolean2){
	//Actions taken if boolean2 is true
else{
	//Actions taken if all booleans are false
}
-If your conditional has a return statement inside, it will terminate if the boolean is true
-System.out.print() is helpful if you dont want a newline
QCC:
-What does terminal interactions mean?
-Why set value to 99... when a input is incorrect?
-What else can we do to improve BankAccount?
-Should we add a pin parameter to deposit and withdrawl?
-How can we structure error messages in a more effective manner?
Q2:
You know that java creates a default constructor becasue if there are not constructors defined in a class and you try to construct it, an instance of the class is still returned. An example of this default constructor is:
public classNam(){
	//no parameters
}
Q3:
BigSib richard = new BigSib();
System.out.println(richard); //Output: "BankAccount@49476842"
*/

public class BankAccount{

	//Intitialization
	private String name;
	private String passwd;
	private short pin;
	private int acctNum;
	private double balance;

	public String toString() {
		String retStr = "\nAccount info:\n=======================";
      		retStr = retStr + "\nName: " + name;
      		retStr = retStr + "\nPassword: " + passwd;
      		retStr = retStr + "\nPIN: " + pin;
      		retStr = retStr + "\nAccount Number: " + acctNum;
      		retStr = retStr + "\nBalance: " + balance;
      		retStr = retStr + "\n=======================";
      		return retStr;
	}
 	
	//mutators
	public String setName( String newName ) {
  		String oldName = name;
		name = newName;
		return oldName;
	}
	
	public String setPasswd( String newPasswd ) {
		String oldPasswd = passwd;
		passwd = newPasswd;
		return oldPasswd;
	}
	
	public short setPin( short newPin ) {
		short oldPin = pin;

		if (newPin < 1000 | newPin > 9998){
			pin = 9999;
			System.out.print("inputed paramter for setPin() is invalid old value: ");
		}
		pin = newPin;
		return oldPin;
	}

	public int setAcctNum( int newAcctNum ) {
		int oldAcctNum = acctNum;

		if (newAcctNum < 100000000 | newAcctNum > 999999998){
			acctNum = 999999999;
			System.out.print("inputed paramter for setAcctNum() is invalid old value: ");
		}
		else{
			acctNum = newAcctNum;
		}

		return oldAcctNum;
	}

	public double setBalance( double newBalance ) {
		double oldBalance = balance;
		balance = newBalance;
		return oldBalance;
	}	

	//Balance Affecting Methods
	//Withdraw	
	public boolean withdraw(double amount){
		System.out.print("Withdrawal Complete: ");
		if (amount > balance){
			return false;
		}
		balance -= amount;
		return true;
	}
	//Deposit
	public void deposit(double amount){
		balance += amount;
	}

	//Security Methods
	public boolean authenticate(int accnt, String pswd){
		System.out.print("Authentication Succesful: ");
		if (accnt == acctNum & pswd.equals(passwd)){
			return true;
		}
		return false;
	}

	//main() method
	public static void main(String[] args){
		//HW 18.5
		//Test for initialization and new toString()
		BankAccount elonMusk = new BankAccount();
		//System.out.println( elonMusk.toString() ); //expecting null values

		//Test for variable changers (mutator methods)
        	System.out.println( "Test for Return Values"); // output should match AccntInfo above	 
        	System.out.println( elonMusk.setName("The Elon Musk") );
		System.out.println( elonMusk.setPasswd("tesla123") );
		System.out.println( elonMusk.setPin( (short)4321 ) );
		System.out.println( elonMusk.setAcctNum(123456789) );
        	System.out.println( elonMusk.setBalance(10000) );
		//System.out.println( elonMusk.toString() );

		//Test for Balance Affecting Methods
		//elonMusk.deposit(5000);
		//elonMusk.withdraw(250);	
		//System.out.println( elonMusk.toString() +"/nHW 19 Tests:" );

		//HW19
		System.out.println("\nTESTS FOR HW19:");
		System.out.println( elonMusk.setAcctNum(64) );
		System.out.println( elonMusk.setPin( (short)-32) );
		System.out.println( elonMusk.withdraw(9999.99) );
		System.out.println( elonMusk.withdraw(420.89) );
		System.out.println( elonMusk.authenticate(999999999, "tesla123"));
		System.out.println( elonMusk.authenticate(987654321, "fordisthebest"));

	}
}
