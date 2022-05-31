package meesho.lld.payoutsystem.model;

import meesho.lld.payoutsystem.constants.PayoutMode;

import java.util.UUID;

public class Payout {

    private UUID id;

    private User user;

    private double amount;

    private UUID orderId;

    private PayoutMode payoutMode;

    private Account account;

    public Payout(User user, double amount, UUID orderId) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.amount = amount;
        this.orderId = orderId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public PayoutMode getPayoutMode() {
        return payoutMode;
    }

    public void setPayoutMode(PayoutMode payoutMode) {
        this.payoutMode = payoutMode;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
