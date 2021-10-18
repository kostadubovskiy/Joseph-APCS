/**
Team Sushi- Ruby Friedman, Joseph Othman, Ivina Wang
APCS
HW18 -- CPA-One
2021-10-17
*/
 
/**
DISCO:
- When we withdraw  more than half the existing AccountBalance, the
  AccountBalance returns a number with 14 decimal places even though
  only 2 decimal places were originally provided.
- What we deposit a value greater than the existing AccountBalance,
  the deposit method returns a number with 14 decimal places even
  though only 2 decimal places were originally provided
- It is possible to create a new instance of a class inside the same
  file, see BankAccount Jared for an example of such.
 
QCC:
- Why is it that when we withdraw a value over half the existing value
  or deposit a value greater than the existing value we get 14 decimal
  places?
 
 
Team Sushi's Latest and Greatest Q2 Response:
The default constructor that Java provides for us is the class, as seen
in line one of our code public class BankAccount, that is Java's default
constructor. When we create a new instance of the class, anything that
shares it name (i.e. the constructor) must be invoked as well. Hence the
default constructor must exist, even if we have not defined it
 
Team Sushi's Latest and Greatest Q3 Response:
In order to test if Java provides a mean of outputting a String representation
we would create a new method with return type String. In this method we would
create a new BankAccount object and try to return it. If it causes an error
message due to the return type then java would not provide a mean of outputting
a String representation of an object, but if the code is able to be run without
error then Java can in fact output a String representation of an object.
Example code for a test:
        public static String test() {
                BankAccount = new Hen.BankAccount();
                return Hen;
        }
*/
 
public class BankAccount {
	// instance variables
	public static String fullName;
	private static String password;
	private static int pin;
	private static int accountNumber;
	private static double accountBalance;
 
	// methods
	private BankAccount(String a, String b, int c, int d, double e) {
		fullName = a;
		password = b;
		pin = c;
		accountNumber = d;
		accountBalance = e;
		}
 
	private static void accountInfo() {
		System.out.println("Account Information:");
		System.out.println("Full name: " + fullName);
		System.out.println("Password: " + password);
		System.out.println("Pin: " + pin);
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Account Balance: " + accountBalance);
		}
 
	private static double deposit(double add) {
		accountBalance = (accountBalance + add);
		return accountBalance;
		}
 
        private static double withdraw(double subtract) {
                accountBalance = (accountBalance - subtract);
                return accountBalance;
                }
	public static void main(String[] args) {
		BankAccount Jared = new BankAccount("Jared Mykolyk", "password", 1234, 987654321, 126.54);
		Jared.accountInfo();
		System.out.print("New Account Balance: ");
		System.out.println(Jared.deposit(126.53));
		System.out.print("New Account Balance: ");
		System.out.println(Jared.withdraw(62.26));
		}
	}
