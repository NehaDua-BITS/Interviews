package intuit.model;

import intuit.constants.TaxIdentifiers;

import java.util.List;
import java.util.Map;

public class Business extends Profile {

    private String legalName;

    private Map<TaxIdentifiers, String> taxIdentifiersMap;

    private String website;

    private List<Subscription> subscriptions;

    public Business(String name) {
        super(name);
    }

    public Business(String name, Address address, List<Contact> contacts) {
        super(name, address, contacts);
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public Map<TaxIdentifiers, String> getTaxIdentifiersMap() {
        return taxIdentifiersMap;
    }

    public void setTaxIdentifiersMap(Map<TaxIdentifiers, String> taxIdentifiersMap) {
        this.taxIdentifiersMap = taxIdentifiersMap;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}

