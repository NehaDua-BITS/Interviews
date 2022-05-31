package intuit.model;

import intuit.constants.ProductType;
import intuit.constants.SubscriptionFrequency;

import java.sql.Date;
import java.util.UUID;

import static intuit.helper.SubscriptionHelper.calculateEndDate;

public class Subscription {

    private UUID id;

    private ProductType productType;

    private Date startDate;

    private Date endDate;

    private SubscriptionFrequency frequency;

    public Subscription(ProductType productType, Date startDate, SubscriptionFrequency frequency) {
        this.productType = productType;
        this.startDate = startDate;
        this.endDate = calculateEndDate(startDate, frequency);
    }
}
