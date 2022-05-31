package meesho.lld.payoutsystem.model;

import meesho.lld.payoutsystem.model.constraints.Constraint;

import java.util.List;

public class BankAccount extends Account {

    private String bankName;

    private final String IIFCCode;

    private Address branchAddress;

    private Balance balance;

    private List<Constraint> constraints;

    public BankAccount(String IIFCCode, Balance balance, List<Constraint> constraints) {
        super();
        this.IIFCCode = IIFCCode;
        this.balance = balance;
        this.constraints = constraints;
    }


    public BankAccount(String bankName, String IIFCCode, Address branchAddress, Balance balance, List<Constraint> constraints) {
        this.bankName = bankName;
        this.IIFCCode = IIFCCode;
        this.branchAddress = branchAddress;
        this.balance = balance;
        this.constraints = constraints;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIIFCCode() {
        return IIFCCode;
    }

    public Address getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(Address branchAddress) {
        this.branchAddress = branchAddress;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<Constraint> constraints) {
        this.constraints = constraints;
    }
}

