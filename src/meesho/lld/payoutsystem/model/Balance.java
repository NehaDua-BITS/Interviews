package meesho.lld.payoutsystem.model;

public class Balance {

    private double currentBalance;

    private double minBalance;

    public Balance() {
    }

    public Balance(double currentBalance, double minBalance) {
        this.currentBalance = currentBalance;
        this.minBalance = minBalance;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}
