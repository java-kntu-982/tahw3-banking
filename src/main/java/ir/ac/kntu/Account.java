package ir.ac.kntu;

/**
 * @author your name
 */
public class Account {
    /*private*/ Long number;
    /*private*/ Double balance;

    //Constructor has been created for you
    public Account(long number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    // TODO: make these methods public
    // FIXME
    /*private*/ void deposit(double amount) {
        //delete this line of code and write the body required for this method
        throw new UnsupportedOperationException("Delete this line - deposit");
    }


    //FIXME
    /*private*/ boolean withdraw(double amount) {
        //delete this line of code and write the body required for this method
        throw new UnsupportedOperationException("Delete this line - withdraw");
    }

    // TODO: write proper getters and setters






    // Don't mind the following method, you will learn about it in the next week
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", balance=" + balance +
                '}';
    }
}
