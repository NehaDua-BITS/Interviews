package meesho.lld.payoutsystem.model.constraints;

import meesho.lld.payoutsystem.constants.PayoutMode;

import java.util.Map;

public class PayoutModeConstraint extends Constraint {

    private Map<PayoutMode, Integer> constraintMap;

    public PayoutModeConstraint() {
    }


    public PayoutModeConstraint(Map<PayoutMode, Integer> constraintMap) {
        this.constraintMap = constraintMap;
    }

    public void updatePayoutLimit(PayoutMode mode, int limit) {
        constraintMap.put(mode, limit);
    }

    public Integer getPayoutModeLimit(PayoutMode mode) {
        Integer limit = constraintMap.get(mode);
        return limit ==  null ? 0 : limit;
    }

    public PayoutMode getValidPayoutMode(int currTransactions) {
       for (Map.Entry<PayoutMode, Integer> entry : constraintMap.entrySet()) {
           if (entry.getValue() < currTransactions) {
               return entry.getKey();
           }
       }
       return null;
    }
}
