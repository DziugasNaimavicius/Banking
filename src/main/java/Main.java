import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccountHandling handler = new BankAccountHandling();

        BankLogin bankLogin = new BankLogin(sc, handler);
        BankAccount currentAccount = bankLogin.accountEntry();

        if (currentAccount != null) {
            BankMenu bankMenu = new BankMenu(sc, handler, currentAccount);
            bankMenu.runMenu();
        }

        sc.close();
    }
}