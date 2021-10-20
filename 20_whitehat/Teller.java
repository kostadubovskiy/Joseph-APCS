public class Teller {

	public static void main(String[] args) {
		BankAccount Jared = new BankAccount();
		Jared.setName("Jared Mykolyk");
		Jared.setPasswd("password");
		short hello = 1234;
		Jared.setPin(hello);
		Jared.setAcctNum(987654321);
		Jared.setBalance(126.54);

		System.out.println("Original values: ");
		System.out.println(Jared.toString());
		System.out.println("withdraw 100 dollars");
		System.out.println(Jared.withdraw(100)); // Too many decimal places!
		System.out.println(Jared.toString());
		System.out.println("deposit 100 dollars");
		Jared.deposit(100);
		System.out.println(Jared.toString());
		System.out.println("withdraw NEGATIVE 100 dollars");
		Jared.withdraw(-100); // Also too many decimals.
		System.out.println(Jared.toString());
		System.out.println("deposit NEGATIVE 100 dollars");
		Jared.deposit(-100);
		System.out.println(Jared.toString());
		System.out.println("deposit NEGATIVE 500 dollars");
		Jared.deposit(-500); // Ends up with a negative balance.
		System.out.println(Jared.toString());
	}
}
