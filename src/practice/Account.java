package practice;

public class Account {
    private static String name;
    private static String bankName;
    private static int accountNumber;
    private static int balance;
    
    public Account(String name, String bankName, int accountNumber, int balance) {
    	this.name = name;
    	this.bankName = bankName;
    	this.accountNumber = Account.accountNumber;
    	this.balance = balance;
    }
   
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Account.name = name;
	}
	public static String getBankName() {
		return bankName;
	}
	public static void setBankName(String bankName) {
		Account.bankName = bankName;
	}
	public static int getAccountNumber() {
		return accountNumber;
	}
	public static void setAccountNumber(int accountNumber) {
		Account.accountNumber = accountNumber;
	}
	public static int getBalance() {
		return balance;
	}
	public static void setBalance(int balance) {
		Account.balance = balance;
	}
}
