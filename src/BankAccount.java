import java.util.Scanner;

public class BankAccount {
    private double balance;

    public BankAccount() {}

    public BankAccount(double balance) {
        this.balance = balance;
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

    public static void main(String[] args) {
        double balance = 10;
        BankAccount account = new BankAccount(balance);

        Scanner sc = new Scanner(System.in);
        System.out.println("For deposit press - 1, for withdraw press - 2, for showing balance press - 3");

        int temp = sc.nextInt();

        switch (temp) {
            case 1:
                System.out.println("Enter the amount to deposit:");
                double depositAmount = sc.nextDouble();
                balance = account.deposit(depositAmount);
                System.out.println("Balance after deposit: " + balance);
                break;
            case 2:
                System.out.println("Enter the amount to withdraw:");
                double withdrawAmount = sc.nextDouble();
                balance = account.withdraw(withdrawAmount);
                System.out.println("Balance after withdrawal: " + balance);
                break;
            case 3:
                account.printBalance();
                break;
        }
        sc.close();
    }
}