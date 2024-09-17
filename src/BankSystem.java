import java.util.*;

public class BankSystem {
    private final List<TransactionManager> transactions = new ArrayList<>();

    private final Account[] accounts = {
            new Account("Account_041", 199500.0), // 0
            new Account("Account_043", 210000.0) // 1
    };

    public static void main(String[] args) {
        BankSystem bs = new BankSystem();
        bs.run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        int op = 99;
        while(true) {
            System.out.println("\n1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your option: ");
            op = sc.nextInt();

            if (op == 1) { // Withdraw
                Account acc = selectAcc(sc);

                if (acc == null)
                    continue;

                double am = getAm(sc);
                addNewTran(acc, am, Transaction.WITHDRAW);
            } else if (op == 2) { // Deposit
                Account acc = selectAcc(sc);

                if (acc == null)
                    continue;

                double am = getAm(sc);
                addNewTran(acc, am, Transaction.DEPOSIT);
            } else if (op == 3) {
                Account acc = selectAcc(sc);

                if (acc == null)
                    continue;

                acc.getBal();
            } else if (op == 4) {
                break;
            } else {
                System.out.println("Invalid option!");
            }

            runTransactions();
        }

        sc.close();
    }

    public int showAccountOption(Scanner sc) {
        int accOp = 0;

        for (int i = 0; i < accounts.length; i++) {
            System.out.println(i + 1 + ". " + accounts[i].getName());
        }
        System.out.print("\nSelect account: ");

        return sc.nextInt();
    }

    public Account selectAcc(Scanner sc) {
        int accOp = showAccountOption(sc);
        Account selAcc = null;

        if (accOp >= 1 && accOp <= 2) {
            selAcc = accounts[accOp - 1];
        } else {
            System.out.println("Invalid option");
        }

        return selAcc;
    }

    public double getAm(Scanner sc) {
        System.out.print("\nEnter amount: ");
        return sc.nextDouble();
    }

    public void addNewTran(Account acc, double am, Transaction tranType) {
        TransactionManager transaction = new TransactionManager(acc, am, tranType);
        transactions.add(transaction);
    }

    public void runTransactions() {
        for (TransactionManager trans : transactions) {
            trans.start();
        }

        transactions.clear();
    }
}
