import java.util.Scanner;

public class BankLogin {
    private Scanner sc;
    private BankAccountHandling handler;

    public BankLogin(Scanner sc, BankAccountHandling handler) {
        this.sc = sc;
        this.handler = handler;
    }

    public BankAccount accountEntry() {
        BankAccount currentAccount = null;
        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.println("Login - 1, Create an account - 2, Exit - 0");
            int choice = sc.nextInt();
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
                        isLoggedIn = true;
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
                    return null;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        return currentAccount;
    }
}