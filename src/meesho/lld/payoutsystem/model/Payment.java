package meesho.lld.payoutsystem.model;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Payment {

    private final UUID id;

    private UUID orderId;

    private UUID userId;

    private ZonedDateTime paymentDate;

    private double amount;

    public Payment(UUID orderId, UUID userId, ZonedDateTime paymentDate, double amount) {
        this.id = UUID.randomUUID();
        this.orderId = orderId;
        this.userId = userId;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public ZonedDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(ZonedDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
