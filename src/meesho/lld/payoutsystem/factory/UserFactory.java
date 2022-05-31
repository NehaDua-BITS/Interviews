package meesho.lld.payoutsystem.factory;

import meesho.lld.payoutsystem.constants.PayoutMode;
import meesho.lld.payoutsystem.constants.UserType;
import meesho.lld.payoutsystem.exception.InvalidUserException;
import meesho.lld.payoutsystem.model.*;
import meesho.lld.payoutsystem.model.constraints.BalanceConstraint;
import meesho.lld.payoutsystem.model.constraints.Constraint;
import meesho.lld.payoutsystem.model.constraints.PayoutModeConstraint;
import meesho.lld.payoutsystem.model.constraints.TransactionLimitConstraint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserFactory {

    public static User createUser(UserType userType) {

        User user = null;
        switch (userType) {
            case CUSTOMER:
                user = new Customer("user1");
                user.addAccount(new BankAccount("ICIC0022", new Balance(1000, 0.0), getConstraintsForBank()));
                user.addAccount(new BankAccount("CITI002", new Balance(200, 0.0), getConstraintsForBank()));
                break;

            case SELLER:
                user = new Seller("seller1");
                user.addAccount(new BankAccount("ICIC0021", new Balance(200.0, 0.0), getConstraintsForBank()));
                user.addAccount(new BankAccount("CIIT223", new Balance(150, 0.0), getConstraintsForBank()));
                break;

            case VENDOR:
                user = new Vendor("vendor1");
                user.addAccount(new BankAccount("ICIC0122", new Balance(50.0, 0.0), getConstraintsForBank()));
                user.addAccount(new BankAccount("CIIT224", new Balance(20, 0.0), getConstraintsForBank()));
                break;

            default:
                throw new InvalidUserException("User type not found");
        }

        return user;
    }

    private static List<Constraint> getConstraintsForBank() {

        Random random = new Random();

        List<Constraint> constraints = new ArrayList<>();

        BalanceConstraint balanceConstraint = new BalanceConstraint();

        PayoutModeConstraint payoutModeConstraint = new PayoutModeConstraint();
        payoutModeConstraint.updatePayoutLimit(PayoutMode.NEFT, random.nextInt(10));
        payoutModeConstraint.updatePayoutLimit(PayoutMode.IMPS, random.nextInt(5));

        TransactionLimitConstraint transactionLimitConstraint = new TransactionLimitConstraint(random.nextInt(20));

        constraints.add(balanceConstraint);
        constraints.add(payoutModeConstraint);
        constraints.add(transactionLimitConstraint);

        return constraints;
    }

}
