package meesho.lld.payoutsystem.model;

import java.util.UUID;

public abstract class Account {

    protected final UUID id;

    protected int dayTransactionsCount;

    public Account() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void incrementTransactionsCount() {
        this.dayTransactionsCount++;
    }

    public void resetTransactionsCount() {
        this.dayTransactionsCount = 0;
    }

    public int getDayTransactionsCount() {
        return dayTransactionsCount;
    }

    public void setDayTransactionsCount(int dayTransactionsCount) {
        this.dayTransactionsCount = dayTransactionsCount;
    }
}
