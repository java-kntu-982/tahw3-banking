package ir.ac.kntu;

import java.util.Arrays;

/**
 * @author your name
 */
public class Bank {
    /*private*/ Account[] accounts;

    // TODO: Uncomment the constructor below: - do not create any other constructors
//    public Bank(Account[] accounts) {
//        this.accounts = accounts;
//    }

    // FIXME: uncomment public keywords
    /*public */Account findAccountByNumber(long accountNumber) {
        throw new UnsupportedOperationException("Delete me - findAccountByNum");
    }

    // FIXME:
    /*public*/ boolean deposit(long accountNumber, double amount) {
        throw new UnsupportedOperationException("Delete me- deposit in Bank");
    }

    //FIXME:
    /*public*/ boolean withdraw(long accountNumber, double amount) {
        throw new UnsupportedOperationException("Delete me - withdraw in bank");
    }

    // FIXME:
    /*public*/ boolean handleTransaction(double amount, long from, long to) {
        //withdraw then deposit
        throw new UnsupportedOperationException("Delete me->handleTransaction");
    }

    public void addToAccounts(Account account) {
        // TODO:  this method adds an account to the accounts array
    }

    //TODO:write proper getters and setters for Account to make this getter work
    public Account[] getAccounts() {
        Account[] copy = new Account[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            // TODO: Uncomment the line bellow
//            copy[i] = new Account(accounts[i].getNumber(), accounts[i].getBalance());
        }
        return copy;
    }//TODO: Think why returning a copy is better!

    // Don't mind the following method, you will learn about it in the next week
    public String toString() {
        return "Bank{" +
                "accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
