package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {


    @Test
    public void minBalanceIsTestFirst() {
        SavingAccount savingAccount = new SavingAccount(170_000, 150_000, 400_000, 2);
        Assertions.assertEquals(150_000, savingAccount.getMinBalance());
    }


    @Test
    public void minBalanceIsTestSecond() {
        SavingAccount savingAccount = new SavingAccount(315, 0, 400_000, 3);
        Assertions.assertEquals(0, savingAccount.getMinBalance());
    }


    @Test
    //// Тест показывает на баг № 1 - Исключение IllegalArgumentException не выкидывается
    //// при отрицательном значении minBalance
    public void minBalanceIsTestThird() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(1_500, -1, 400_000, 4);
        });
    }


    @Test
    //// Тест показывает на баг № 2 - Исключение IllegalArgumentException не выкидывается
    ////при значении minBalance большем, чем значение maxBalance
    public void minBalanceIsTestFourth() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(1_500, 500_000, 400_000, 4);
        });
    }


    @Test
    public void maxBalanceTestFifth() {
        SavingAccount savingAccount = new SavingAccount(1_750, 0, 50_000, 7);
        Assertions.assertEquals(50_000, savingAccount.getMaxBalance());
    }

    @Test
    //// Тест показывает на баг № 3 - Исключение IllegalArgumentException не выкидывается
    //// при отрицательном значении maxBalance
    public void maxBalanceTestSixth() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(3_750, 0, -1, 12);
        });
    }


    @Test

    public void maxBalanceTestSeventh() {
        SavingAccount savingAccount = new SavingAccount(3_500, 0, 10_000, 9);
        Assertions.assertEquals(10_000, savingAccount.getMaxBalance());
    }


    @Test
    //// Тест показывает на баг № 4 - Исключение IllegalArgumentException не выкидывается
    //// при значении maxBalance меньшем, чем значение minBalance
    public void maxBalanceTestEighth() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(11_000, 10_000, 5_000, 12);
        });
    }


    @Test
    public void initialBalanceTestNinth() {
        SavingAccount savingAccount = new SavingAccount(25_000, 0, 150_000, 14);
        Assertions.assertEquals(25_000, savingAccount.getBalance());
    }


    @Test
    public void initialBalanceTestTenth() {
        SavingAccount savingAccount = new SavingAccount(0, 0, 150_000, 14);
        Assertions.assertEquals(0, savingAccount.getBalance());
    }

    @Test
    //// Тест показывает на баг № 5 - Исключение IllegalArgumentException не выкидывается
    //// при отрицательном значении initialBalance
    public void initialBalanceTestEleventh() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(-1, 0, 150_000, 13);
        });
    }


    @Test
    //// ***** Тест показывает на баг -Исключение IllegalArgumentException не выкидывается
    ////  в ситуации  когда initialBalance меньше чем minBalance возможно лишний тест ?????
    public void initialBalanceTestTwelfth() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(50, 500, 150_000, 13);
        });
    }


    @Test
    //// Тест показывает на баг № 6 - Исключение IllegalArgumentException не выкидывается
    //// при значении initialBalance большем, чем значение maxBalance
    public void initialBalanceTestThirteenth() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(160_000, 500, 150_000, 13);
        });
    }


    @Test
    public void rateTestFourteenth() {
        SavingAccount savingAccount = new SavingAccount(0, 0, 0, 15);
        Assertions.assertEquals(15, savingAccount.getRate());
    }


    @Test
    public void rateTestFifteenth() {
        SavingAccount savingAccount = new SavingAccount(0, 0, 0, 0);
        Assertions.assertEquals(0, savingAccount.getRate());
    }


    @Test
    public void rateTestSixteenth() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(1_750, 0, 250_000, -1);
        });
    }


    @Test
    public void payTestSeventeenth() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        savingAccount.pay(6_750);
        Assertions.assertEquals(28_250, savingAccount.getBalance());
    }


    @Test
    public void payTestEighteenth() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        savingAccount.pay(0);
        Assertions.assertEquals(35000, savingAccount.getBalance());
    }


    @Test
    public void payTestNineteenth() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        savingAccount.pay(-1);
        Assertions.assertEquals(35000, savingAccount.getBalance());
    }


    @Test
    public void payTestTwentieth() {
        //// Тест показывает на баг № 7 - Отрицательный баланс при сумме покупки amount превышающей
        //// остаток на  балансе
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        savingAccount.pay(37000);
        Assertions.assertEquals(35_000, savingAccount.getBalance());
    }


    @Test
    public void payTestTwentyFirst() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        Boolean expected = false;
        Boolean actual = savingAccount.pay(37_000);

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void payTestTwentySecond() {
        //// Тест показывает на баг № 8 - Отрицательный баланс при сумме покупки amount превышающей
        //// установленный maxBalance
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        savingAccount.pay(3_700_000);
        Assertions.assertEquals(35_000, savingAccount.getBalance());
    }

    @Test
    public void payTestTwentyThird() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        Boolean expected = false;
        Boolean actual = savingAccount.pay(3_750_000);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void payTestTwentyFourth() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        Boolean expected = true;
        Boolean actual = savingAccount.pay(3450);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void payTestTwentyFifth() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        Boolean expected = false;
        Boolean actual = savingAccount.pay(0);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void payTestTwentySixth() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        Boolean expected = false;
        Boolean actual = savingAccount.pay(-100);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    //// Тест показывает на баг № 9 Переменная initialBalance (начальный баланс) не учитывается
    //// в итоговом балансе при пополнении счёта
    public void addTestTwentySeventh() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        savingAccount.add(253_640);
        Assertions.assertEquals(288_640, savingAccount.getBalance());
    }


    @Test
    public void addTestTwentyEighth() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        savingAccount.add(750_640);
        Assertions.assertEquals(35_000, savingAccount.getBalance());
    }


    @Test
    //// Тест показывает на баг № 10 - Не отображается корректно итоговый баланс в пределах допустимого
    //// максимального значения maxBalance при пополнении счёта
    public void addTestTwentyNinth() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        savingAccount.add(465_000);
        Assertions.assertEquals(500_000, savingAccount.getBalance());
    }


    @Test
    public void addTestThirtieth() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        savingAccount.add(0);
        Assertions.assertEquals(35000, savingAccount.getBalance());
    }


    @Test
    public void addTestThirtyFirst() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        savingAccount.add(-150);
        Assertions.assertEquals(35000, savingAccount.getBalance());
    }


    @Test
    public void addTestThirtySecond() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        Boolean expected = true;
        Boolean actual = savingAccount.add(7_500);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void addTestThirtyThird() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        Boolean expected = false;
        Boolean actual = savingAccount.add(0);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void addTestThirtyFourth() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        Boolean expected = false;
        Boolean actual = savingAccount.add(-350);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void yearChangeTestThirtyFifth() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        Assertions.assertEquals(5_600, savingAccount.yearChange());
    }


    @Test
    public void yearChangeTestThirtySixth() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 0);
        Assertions.assertEquals(0, savingAccount.yearChange());
    }


    @Test
    //// Баг № 11 - Переменная rate в функции yearChange не имеет ограничение на максимально допустимое значение.
    //// Хотелось бы видеть ноль, возможно это можно использовать как предложение по улучшению кода....
    public void yearChangeTestThirtySeventh() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 1060);
        Assertions.assertEquals(371_000, savingAccount.yearChange());
    }
}

