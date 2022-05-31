package meesho.lld.payoutsystem.service.impl;

import meesho.lld.payoutsystem.constants.PayoutMode;
import meesho.lld.payoutsystem.exception.InvalidInputException;
import meesho.lld.payoutsystem.exception.NoValidBankForPayout;
import meesho.lld.payoutsystem.model.Account;
import meesho.lld.payoutsystem.model.BankAccount;
import meesho.lld.payoutsystem.model.Payout;
import meesho.lld.payoutsystem.model.User;
import meesho.lld.payoutsystem.model.constraints.BalanceConstraint;
import meesho.lld.payoutsystem.model.constraints.Constraint;
import meesho.lld.payoutsystem.model.constraints.PayoutModeConstraint;
import meesho.lld.payoutsystem.model.constraints.TransactionLimitConstraint;
import meesho.lld.payoutsystem.service.PayoutControlService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PayoutControlServiceImpl implements PayoutControlService {

    @Override
    public Map<UUID, List<Payout>> aggregate(List<Payout> payouts) {
        return null;
    }

    @Override
    public List<Payout> identifyPayoutBankAndMode(List<Payout> payouts) {
        if (payouts == null || payouts.size() == 0) {
            throw new InvalidInputException("Payout list is null or empty");
        }

        for (int i = 0; i < payouts.size(); i++) {
            Payout payout = identifyPayoutBankAndMode(payouts.get(i));
            if (payout == null) {
                throw new NoValidBankForPayout("No bank found for payout");
            }
        }

        return payouts;
    }

    @Override
    public Payout identifyPayoutBankAndMode(Payout payout) {

        User user = payout.getUser();
        List<Account> accountList = user.getAccountList();

        int length = accountList.size();
        for (int i = 0; i < length; i++) {
            BankAccount account = (BankAccount) accountList.get(i);
            if (areConstraintSatisfied(account.getConstraints(), account, user, payout)) {
                payout.setAccount(account);
                return payout;
            }
        }
        return null;
    }

    private boolean areConstraintSatisfied(List<Constraint> constraint, BankAccount account, User user, Payout payout) {
        BalanceConstraint balanceConstraint = null;
        TransactionLimitConstraint transactionLimitConstraint = null;
        PayoutModeConstraint payoutModeConstraint = null;

        for (int i = 0; i < constraint.size(); i++) {
            if (constraint instanceof BalanceConstraint) {
                balanceConstraint = (BalanceConstraint) constraint;
            } else if (constraint instanceof TransactionLimitConstraint) {
                transactionLimitConstraint = (TransactionLimitConstraint) constraint;
             } else if (constraint instanceof PayoutModeConstraint) {
                payoutModeConstraint = (PayoutModeConstraint) constraint;
             }
        }
        PayoutMode mode = payoutModeConstraint.getValidPayoutMode(account.getDayTransactionsCount());

        boolean areSatisfied = balanceConstraint.isConstraintSatisfied(account.getBalance(), payout.getAmount())
                && transactionLimitConstraint.isConstraintSatisfied(account.getDayTransactionsCount());

        if (areSatisfied && mode != null) {
            payout.setPayoutMode(mode);
            return true;
        }

        return false;
    }
}
