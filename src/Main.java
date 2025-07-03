import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Scanner sc = new Scanner(System.in);
        File file = new File("Accounts.txt");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error creating file.");
            return;
        }

        int choice = -1;
        boolean found = false;

        while (choice != 0) {
            System.out.println("Login - 1, Create an account - 2, Exit - 0");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String loginUser = sc.nextLine();
                    System.out.print("Enter password: ");
                    String loginPass = sc.nextLine();

                    try (Scanner fileScanner = new Scanner(file)) {
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            String[] parts = line.split(",");
                            if (parts.length == 3) {
                                String fileUser = parts[0];
                                String filePass = parts[1];
                                double fileBalance = Double.parseDouble(parts[2]);

                                if (fileUser.equals(loginUser) && filePass.equals(loginPass)) {
                                    account.setBalance(fileBalance);
                                    account.setUser(fileUser);
                                    account.setPassword(filePass);
                                    System.out.println("Login successful.");
                                    found = true;
                                    choice = 0;
                                    break;
                                }
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading from file.");
                    }

                    if (!found) {
                        System.out.println("Login failed.");
                    }

                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String newUser = sc.nextLine();
                    System.out.print("Enter password: ");
                    String newPass = sc.nextLine();

                    try (FileWriter fw = new FileWriter(file, true)) {
                        fw.write(newUser + "," + newPass + "," + 0 + "\n");
                        System.out.println("Account created successfully.");
                    } catch (IOException e) {
                        System.out.println("Error");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }

        choice = -1;
        while (found  && choice != 0) {
            System.out.println("Deposit - 1, Withdraw - 2, Show balance - 3, Exit - 0");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to deposit:");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Balance after deposit: " + account.getBalance());
                    break;
                case 2:
                    System.out.println("Enter the amount to withdraw:");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    System.out.println("Balance after withdrawal: " + account.getBalance());
                    break;
                case 3:
                    account.printBalance();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        sc.close();
    }
}