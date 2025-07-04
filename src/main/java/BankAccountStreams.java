import java.io.*;
import java.util.Map;

public class BankAccountStreams {
    private static final String accountsFile = "Accounts.csv";

    public static void saveAccounts(Map<Integer, BankAccount> accounts) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(accountsFile))) {
            for (BankAccount account : accounts.values()) {
                String line = account.getAccountNumber() + "," +
                        account.getUser() + "," +
                        account.getPassword() + "," +
                        account.getBalance();
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error saving accounts to file: " + e.getMessage());
        }
    }

    public static void loadAccounts(Map<Integer, BankAccount> accounts) {
        File file = new File(accountsFile);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(accountsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 4) continue;

                int accNum = Integer.parseInt(parts[0]);
                String user = parts[1];
                String pass = parts[2];
                double balance = Double.parseDouble(parts[3]);

                BankAccount account = new BankAccount();
                account.setAccountNumber(accNum);
                account.setUser(user);
                account.setPassword(pass);
                account.setBalance(balance);

                accounts.put(accNum, account);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }
}
