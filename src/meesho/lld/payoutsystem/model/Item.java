package meesho.lld.payoutsystem.model;

import java.util.UUID;

public class Item {

    private final UUID id;

    private String name;

    private double amount;

    public Item(String name, double amount) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.amount = amount;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
