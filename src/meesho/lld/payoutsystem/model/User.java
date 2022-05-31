package meesho.lld.payoutsystem.model;

import meesho.lld.payoutsystem.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

    protected final UUID id;

    protected String name;

    protected Address address;

    protected List<Account> accountList;

    protected List<Order> orderList;

    public User(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.accountList = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void addAccount(Account account) {
        if (account == null) {
            throw new InvalidInputException("Account cannot be null for addition");
        }
        this.accountList.add(account);
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
