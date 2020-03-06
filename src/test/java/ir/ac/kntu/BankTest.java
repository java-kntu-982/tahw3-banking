package ir.ac.kntu;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author S.Shayan Daneshvar
 */
@SuppressWarnings("JavaReflectionMemberAccess")
public class BankTest {
    private final long ID1 = 1L, ID2 = 2L, ID3 = 3L, ID4 = 4L, ID5 = 5L;
    private final double BAL1 = 200d, BAL2 = 220d, BAL3 = 900d, BAL4 = 1204d,
            BAL5 = 9d;
    private final Account account = new Account(ID5, BAL5);
    private Bank bank;

    @BeforeEach
    public void setUp() throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException,
            ClassNotFoundException {
        Account[] accounts = new Account[]{
                new Account(ID1, BAL1),
                new Account(ID2, BAL2),
                new Account(ID3, BAL3),
                new Account(ID4, BAL4),
                account};
        bank = Bank.class.getConstructor(Class.forName("[Lir.ac.kntu.Account;"))
                .newInstance((Object) accounts);
    }

    @BeforeAll
    public static void start() {
        System.err.println("#### Starting Unit Tests | Bank ####");
    }

    @Test
    public void findAccountByNumber() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        final Account ACC = bank.findAccountByNumber(ID1);
        final Account ACC3 = bank.findAccountByNumber(ID3);
        final Account ACC5 = bank.findAccountByNumber(ID5);
        assertEquals((double) ACC.getClass().getDeclaredMethod("getBalance")
                .invoke(ACC), BAL1);
        assertEquals((long) ACC.getClass().getDeclaredMethod("getNumber")
                .invoke(ACC), ID1);
        assertEquals((double) ACC3.getClass().getDeclaredMethod("getBalance")
                .invoke(ACC3), BAL3);
        assertEquals((long) ACC3.getClass().getDeclaredMethod("getNumber")
                        .invoke(ACC3),
                ID3);
        assertEquals((double) ACC5.getClass().getDeclaredMethod("getBalance")
                .invoke(ACC5), BAL5);
        assertEquals((long) ACC5.getClass().getDeclaredMethod("getNumber")
                .invoke(ACC5), ID5);
    }

    @Test
    public void deposit() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Account acc2 = bank.findAccountByNumber(ID2);
        final Method DEPOSIT = Bank.class
                .getDeclaredMethod("deposit", long.class, double.class);
        DEPOSIT.setAccessible(true);
        Boolean test1 = (Boolean) DEPOSIT.invoke(bank, ID2, 100);

        Boolean test2 = !(Boolean) DEPOSIT.invoke(bank, 12341L, 200);
        DEPOSIT.setAccessible(false);
        assertEquals((double) acc2.getClass().
                getDeclaredMethod("getBalance").invoke(acc2), (BAL2 + 100));
        assertTrue(test1 && test2);
    }

    @Test
    public void withdraw() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Account acc4 = bank.findAccountByNumber(ID4);
        final Method WITHDRAW = Bank.class.getDeclaredMethod("withdraw", long.class, double.class);
        WITHDRAW.setAccessible(true);
        boolean test1 = (Boolean) WITHDRAW.invoke(bank, ID4, 100);
        boolean test2 = !(Boolean) WITHDRAW.invoke(bank, 12141L, 120);
        WITHDRAW.setAccessible(false);
        assertEquals((double) acc4.getClass().getDeclaredMethod("getBalance")
                .invoke(acc4), (BAL4 - 100));
        assertTrue(test1 && test2);
    }

    @Test
    public void handleTransaction1() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        final long amount1 = 100L;
        boolean test = bank.handleTransaction(amount1, ID1, ID3);
        Account acc1 = bank.findAccountByNumber(ID1);
        Account acc3 = bank.findAccountByNumber(ID3);
        assertEquals((double) acc1.getClass().getDeclaredMethod("getBalance")
                .invoke(acc1), (BAL1 - amount1));
        assertEquals((double) acc3.getClass().getDeclaredMethod("getBalance")
                .invoke(acc3), (BAL3 + amount1));
        assertTrue(test);
    }

    @Test
    public void handleTransaction2() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        final long amount = 991L;
        boolean test2 = bank.handleTransaction(amount, ID5, ID3);
        assertFalse(test2);
        assertEquals(bank.findAccountByNumber(ID5).getClass().getDeclaredMethod(
                "getBalance").invoke(bank.findAccountByNumber(ID5)), BAL5);
        assertEquals(bank.findAccountByNumber(ID3).getClass().getDeclaredMethod(
                "getBalance").invoke(bank.findAccountByNumber(ID3)), BAL3);
    }

    @AfterAll
    public static void end() {
        System.err.println("#### End of testing | Bank ####");
    }
}
