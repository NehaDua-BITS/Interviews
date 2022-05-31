package meesho.lld.payoutsystem.exception;

public class NoValidBankForPayout extends PayoutException{
    public NoValidBankForPayout(String message) {
        super(message);
    }
}
