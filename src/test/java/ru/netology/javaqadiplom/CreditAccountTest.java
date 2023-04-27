package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditAccountTest {
    @Test
    public void shouldAddToPositiveBalanceWhenInitialBalanceZero() {
        CreditAccount account = new CreditAccount(0, 5_000, 15);
        account.add(3_000);
        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(1000, 5_000, 15);
        account.add(3_000);
        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    public void shouldThrowExceptionWhenCreatingCreditAccountWithNegativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-100, 5_000, 15);
        });
    }

    @Test
    public void shouldThrowExceptionWhenCreatingCreditAccountWithNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(0, -5000, 15);
        });
    }

    @Test
    public void shouldThrowExceptionWhenCreatingCreditAccountWithNegativeInterestRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(0, 5_000, -1);
        });
    }

    @Test
    public void testPositiveBalanceAfterMakingPurchaseWithinCreditLimit() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);
        account.pay(999);
        Assertions.assertEquals(1, account.getBalance());
    }

    @Test
    public void testZeroBalanceAfterFullAmount() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);
        account.pay(1000);
        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void negativeBalanceAfterAmount() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);
        account.pay(5_000);

        Assertions.assertEquals(-4_000, account.getBalance());
    }

    @Test
    public void testNegativeBalanceAfterPurchaseOverCreditLimit() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);
        account.pay(8000);
        Assertions.assertEquals(1000, account.getBalance());
    }


    @Test
    public void testAddNegativeAmount() {
        CreditAccount account = new CreditAccount(0, 5000, 15);
        assertFalse(account.add(-100)); // Операция должна завершиться вернув false
        assertEquals(0, account.getBalance()); // Баланс не должен измениться
    }

    @Test
    public void testAddZeroAmount() {
        CreditAccount account = new CreditAccount(0, 5000, 15);
        assertFalse(account.add(0)); // Операция должна завершиться вернув false
        assertEquals(00, account.getBalance()); // Баланс не должен измениться
    }

    @Test
    public void testAddPositiveAmount() {
        CreditAccount account = new CreditAccount(0, 5000, 15);
        assertTrue(account.add(100)); // Операция должна завершиться успешно
        assertEquals(100, account.getBalance()); // Баланс должен быть равен сумме пополнения
    }


    @Test
    public void testYearChangeWithNegativeBalanceWhenPayFullAmount() {
        CreditAccount account = new CreditAccount(2_000, 5_000, 15);
        account.pay(3_000);

        Assertions.assertEquals(-315, account.yearChange());
    }

    @Test
    public void testYearChangeWithPositiveBalance() {
        CreditAccount account = new CreditAccount(2_000, 5_000, 15);
        account.pay(1500);

        Assertions.assertEquals(0, account.yearChange());
    }

}
