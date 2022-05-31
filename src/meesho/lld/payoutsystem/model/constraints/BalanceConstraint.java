package meesho.lld.payoutsystem.model.constraints;

import meesho.lld.payoutsystem.model.Balance;

public class BalanceConstraint extends Constraint {

    public boolean isConstraintSatisfied(Balance currBalance, double transactionAmount) {
        return (currBalance.getCurrentBalance() - transactionAmount) >= currBalance.getMinBalance();
    }

}
