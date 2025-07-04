public class BankAccount {
    private int accountNumber;
    private String user;
    private String password;
    private double balance;
    private String currency;

    public BankAccount() {}

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public BankAccount(int accountNumber,double balance, String user, String password) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.user = user;
        this.password = password;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}