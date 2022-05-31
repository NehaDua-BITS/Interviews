package intuit.model;

import intuit.exceptions.InvalidValueException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Profile {

    protected final UUID id;

    protected String name;

    protected Address address;

    protected List<Contact> contacts;

    public Profile(String name) {
        this(name, null, null);
    }

    public Profile(String name, Address address, List<Contact> contacts) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.address = address;
        this.contacts = contacts;
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

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new InvalidValueException("Contact cannot be null");
        }

        if (this.contacts == null) {
            this.contacts = new ArrayList<>();
        }
        this.contacts.add(contact);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", contacts=" + contacts +
                '}';
    }
}
