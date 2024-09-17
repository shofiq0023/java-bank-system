public class Account {
    private final String accName;
    private double bal;

    public Account(String accName, double bal) {
        this.accName = accName;
        this.bal = bal;
    }

    public synchronized void withdraw(double am) {
        if (am > 0 && bal >= am) {
            bal -= am;
            System.out.println();
            showMessage("withdraw from", am);
            showNewBalance();
        } else {
            System.out.println("Invalid withdraw request");
        }
    }

    public synchronized void deposit(double am) {
        if (am > 0) {
            bal += am;
            System.out.println();
            showMessage("deposit into", am);
            showNewBalance();
        } else {
            System.out.println("Invalid deposit request");
        }
    }

    public String getName() {
        return accName;
    }

    public void getBal() {
        System.out.println("> " + accName + ": " + bal);
    }

    private void showMessage(String str, double am) {
        System.out.println("> " + am + " " + str + " " + accName);
    }

    private void showNewBalance() {
        System.out.println("New balance: " + bal);
    }
}
