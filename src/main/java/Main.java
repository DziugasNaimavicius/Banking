import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccountHandling handler = new BankAccountHandling();
        BankAccount currentAccount = null;

        int choice = -1;
        while (choice != 0) {
            System.out.println("Login - 1, Create an account - 2, Exit - 0");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    int accNum = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter password: ");
                    String pass = sc.nextLine();

                    BankAccount loginAcc = handler.accounts.get(accNum);
                    if (loginAcc != null && loginAcc.getPassword().equals(pass)) {
                        System.out.println("Login successful.");
                        currentAccount = loginAcc;
                        choice = 0;
                    } else {
                        System.out.println("Login failed. Invalid account number or password.");
                    }
                    break;

                case 2:
                    System.out.print("Enter new account number: ");
                    int newAccNum = sc.nextInt();
                    sc.nextLine();
                    if (handler.accounts.containsKey(newAccNum)) {
                        System.out.println("Account number already exists.");
                        break;
                    }

                    System.out.print("Enter username: ");
                    String newUser = sc.nextLine();
                    System.out.print("Enter password: ");
                    String newPass = sc.nextLine();

                    BankAccount newAccount = new BankAccount();
                    newAccount.setAccountNumber(newAccNum);
                    newAccount.setUser(newUser);
                    newAccount.setPassword(newPass);
                    newAccount.setBalance(0);

                    handler.createAccount(newAccount);
                    System.out.println("Account created successfully.");
                    break;

                case 0:
                    System.out.println("Have a nice day! :)");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }

        if (currentAccount != null) {
            choice = -1;
            while (choice != 0) {
                System.out.println("Deposit - 1, Withdraw - 2, Show balance - 3, Exit - 0");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double dep = sc.nextDouble();
                        handler.deposit(currentAccount.getAccountNumber(), dep);
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double wd = sc.nextDouble();
                        handler.withdraw(currentAccount.getAccountNumber(), wd);
                        break;

                    case 3:
                        handler.printBalance(currentAccount.getAccountNumber());
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
        }

        sc.close();
    }
}
