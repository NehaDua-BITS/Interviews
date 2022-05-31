package meesho.lld.payoutsystem.model;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID id;

    private ZonedDateTime creationTimestamp;

    private double amount;

    private List<Item> items;


    public Order(double amount) {
        this.id = UUID.randomUUID();
        this.creationTimestamp = ZonedDateTime.now();
        this.amount = amount;
        this.items = new ArrayList<>(); //creating dummy item list
    }

    public UUID getId() {
        return id;
    }

    public ZonedDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
