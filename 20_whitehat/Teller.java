/*
Team Sushi- Ruby Friedman, Joseph Othman, Ivina Wang
APCS
HW20 -- External Audit
2021-10-19

DISCO:
- The bank returned a number with 14 decimal places when we withdraw more than half the existing AccountBalance, even though only 2 decimal places were originally provided. This is a definite issue and vulnerability with the bank.
- If one were to use the deposit method to deposit negative money, (essentially withdrawing money using the deposit method) it’s possible to get a negative balance. This way of withdrawing money is able to escape the if statements in the withdraw method and take more money than there is in the bank account.
- A way to fix the vulnerability mentioned in the discovery above would be to add an if statement in the deposit function that only lets you deposit positive sums of money.
- All private variables are only accessible through BankAccount.java and not Teller.java.
- Public methods were executable in Teller.java, even though they used private variables.
QCC:
- Why is it that withdrawing a value over half the existing value or depositing a value greater than the existing value returns 14 decimal places when only 2 are provided?

*/




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
		System.out.println(Jared.balance);
	}
}
