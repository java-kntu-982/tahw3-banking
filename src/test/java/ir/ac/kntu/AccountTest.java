package ir.ac.kntu;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author S.Shayan Daneshvar
 */
public class AccountTest {

    @BeforeAll
    public static void start() {
        System.err.println("#### Starting Unit Tests | Account ####");
    }

    @Test
    public void depositTest() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        final long NUMBER = 1234L;
        final double BALANCE = 1000d;
        final double ADD = 1000d;
        Account account = new Account(NUMBER, BALANCE);
        account.deposit(ADD);
        Assertions.assertEquals((double) account.getClass().getMethod(
                "getBalance").invoke(account), (BALANCE + ADD));
    }

    @Test
    public void withdrawTest1() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        final long NUMBER = 1334L;
        final double BALANCE = 1200d;
        final double DEL = 1000d;
        Account account = new Account(NUMBER, BALANCE);
        boolean test = account.withdraw(DEL);
        assertTrue(test);
        Assertions.assertEquals((double) account.getClass().getMethod(
                "getBalance").invoke(account), BALANCE - DEL);
    }

    @Test
    public void withdrawTest2() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        final long NUMBER = 3234L;
        final double BALANCE = 1000d;
        final double DEL = 1920d;
        Account account = new Account(NUMBER, BALANCE);
        boolean test = account.withdraw(DEL);
        assertFalse(test);
        Assertions.assertEquals((double) account.getClass()
                .getMethod("getBalance").invoke(account), BALANCE);
    }

    @AfterAll
    public static void end() {
        System.err.println("#### End Of Testing | Account ####");
    }
}