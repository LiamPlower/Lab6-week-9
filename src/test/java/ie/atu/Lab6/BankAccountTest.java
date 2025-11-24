package ie.atu.Lab6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    BankAccount account = new BankAccount();

    @BeforeEach
    void setup() {
        account = new BankAccount();
        account = new BankAccount("ACC12345", "Liam", 100);
    }


    @Test
    void constructorInitialisation() {
        account = new BankAccount("ACC12345", "Liam", 100);
        assertEquals("ACC12345", account.getAccNo());
        assertEquals("Liam", account.getName());
        assertEquals(100, account.getBalance());


    }

    @Test
    void constructorNegativeInitialisation() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new BankAccount("ACC12345", "Liam", -100));
        assertEquals("Balance must be greater than 0.", ex.getMessage());
    }

    @Test
    void depositPositive() {
        account.deposit(50);
        assertEquals(150, account.getBalance(),
                "Depositing a positive amount should increase the balance.");

    }
    @Test
    void depositZeroThrowsException()
    {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> account.deposit(0));

        assertEquals("Deposit amount must be greater than 0.", ex.getMessage());
    }

    @Test
    void depositNegativeThrowsException()
    {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> account.deposit(-20));

        assertEquals("Deposit amount must be greater than 0.", ex.getMessage());


    }
}


