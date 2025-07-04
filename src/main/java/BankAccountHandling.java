import java.util.HashMap;
import java.util.Map;

public class BankAccountHandling {
    public Map<Integer, BankAccount> accounts = new HashMap<>();

    public BankAccountHandling() {
        BankAccountStreams.loadAccounts(accounts);
    }

    public void createAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
        BankAccountStreams.saveAccounts(accounts);
    }

    public void deposit(int accountNumber, double amount) {
        BankAccount account = getValidAccount(accountNumber);
        if (account == null || !isValidAmount(amount)) return;

        account.setBalance(account.getBalance() + amount);
        System.out.println("Successfully deposited " + amount + " Eur");
        BankAccountStreams.saveAccounts(accounts);
    }

    public void withdraw(int accountNumber, double amount) {
        BankAccount account = getValidAccount(accountNumber);
        if (account == null || !isValidAmount(amount)) return;

        account.setBalance(account.getBalance() - amount);
        System.out.println("Successfully withdrawn " + amount + " Eur");
        BankAccountStreams.saveAccounts(accounts);
    }

    public void printBalance(int accountNumber) {
        BankAccount account = getValidAccount(accountNumber);
        if (account == null) return;

        System.out.println("Remaining balance is " + account.getBalance());
    }

    private BankAccount getValidAccount(int accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Invalid account number!");
        }
        return account;
    }

    private boolean isValidAmount(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return false;
        }
        return true;
    }
}
