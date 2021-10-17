public class BankAccount {
	public static String fullname;
	private static String password;
	private static int pin;
	private static int accountNumber;
	private static double accountBalance;

	private static void setAttributes(String a, String b, int c, int d, double e) {
		fullname = a;
		password = b;
		pin = c;
		accountNumber = d;
		accountBalance = e;
	}

	private static void accountInfo() {
		System.out.println("Full name: " + fullname);
		System.out.println("Pin: " + pin);
		System.out.println("Account Balance: " + accountBalance);
	}


	private static void deposit(double add) {
		accountBalance = accountBalance + add;
	}

	private static void withdraw(double subtract) {
                accountBalance = accountBalance - subtract;
        }

	public static void main(String[] args) {
		setAttributes("John Doe", "password", 1234, 987654321, 0);
		accountInfo();
		deposit(500);
		accountInfo();
		withdraw(1000);
		accountInfo();
	}

}

