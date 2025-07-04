import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {
    @Test
    public void testSettersAndGetters() {
        BankAccount acc = new BankAccount();
        acc.setUser("jonas");
        acc.setPassword("slaptas");
        acc.setAccountNumber(321);

        assertEquals("jonas", acc.getUser());
        assertEquals("slaptas", acc.getPassword());
        assertEquals(321, acc.getAccountNumber());
    }
}
