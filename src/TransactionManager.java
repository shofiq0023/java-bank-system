public class TransactionManager extends Thread {
    private final Account acc;
    private final double am;
    private final Transaction tran;

    public TransactionManager(Account acc, double am, Transaction tran) {
        this.acc = acc;
        this.am = am;
        this.tran = tran;
    }

    @Override
    public void run() {
        if (tran.equals(Transaction.WITHDRAW)) {
            acc.withdraw(am);
        } else {
            acc.deposit(am);
        }
    }
}
