package intuit.model;

import intuit.constants.ContactType;

import java.util.UUID;

public class Contact {

    private final UUID id;

    private final ContactType type;

    private String value;

    public Contact(ContactType type, String value) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public ContactType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
