package meesho.lld.payoutsystem.model.constraints;

public class TransactionLimitConstraint extends Constraint {

    private int maxTransactionsPerDay;

    public TransactionLimitConstraint(int maxTransactionsPerDay) {
        this.maxTransactionsPerDay = maxTransactionsPerDay;
    }

    public int getMaxTransactionsPerDay() {
        return maxTransactionsPerDay;
    }

    public void setMaxTransactionsPerDay(int maxTransactionsPerDay) {
        this.maxTransactionsPerDay = maxTransactionsPerDay;
    }

    public boolean isConstraintSatisfied(int currTransactions) {
        return currTransactions < maxTransactionsPerDay;
    }
}
