import java.util.Scanner;

public class BankMenu {
    Scanner sc;
    BankAccountHandling handler;
    BankAccount currentAccount;

    public BankMenu(Scanner sc, BankAccountHandling handler, BankAccount currentAccount) {
        this.sc = sc;
        this.handler = handler;
        this.currentAccount = currentAccount;
    }

    public void runMenu() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("Deposit - 1, Withdraw - 2, Show balance - 3, Transfer - 4, Exit - 0");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();
                    handler.deposit(currentAccount.getAccountNumber(), deposit);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();
                    handler.withdraw(currentAccount.getAccountNumber(), withdraw);
                    break;

                case 3:
                    handler.printBalance(currentAccount.getAccountNumber());
                    break;
                case 4:
                    System.out.println("Enter target account number: ");
                    int targetAccountNumber = sc.nextInt();
                    System.out.println("Enter amount to transfer");
                    double transfer = sc.nextDouble();
                    handler.transfer(currentAccount.getAccountNumber(), targetAccountNumber, transfer);
                    break;

                case 0:
                    System.out.println("Exiting...\nHave a nice day! :)");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
