public class BankAccount {
    private double balance;
    private String user;
    private String password;

    public BankAccount() {}

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public BankAccount(double balance, String user, String password) {
        this.balance = balance;
        this.user = user;
        this.password = password;
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Not enough money in your bank :( !");
            return balance;
        }
        balance -= amount;
        return balance;
    }

    public void printBalance() {
        System.out.println("Current balance: " + balance);
    }
}