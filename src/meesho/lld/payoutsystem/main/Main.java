package meesho.lld.payoutsystem.main;

import meesho.lld.payoutsystem.constants.UserType;
import meesho.lld.payoutsystem.factory.UserFactory;
import meesho.lld.payoutsystem.model.Order;
import meesho.lld.payoutsystem.model.Payout;
import meesho.lld.payoutsystem.model.User;
import meesho.lld.payoutsystem.service.PayoutControlService;
import meesho.lld.payoutsystem.service.impl.PayoutControlServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Main().performPayout();
    }

    private void performPayout() {
        //PayoutInfo(orderId, customerId, customerAmount, sellerId, sellerAmount, vendorId, vendorAmount, paymentDate)
        PayoutControlService payoutControlService = new PayoutControlServiceImpl();

        //create users
        User customer1 = UserFactory.createUser(UserType.CUSTOMER);
        User seller1 = UserFactory.createUser(UserType.SELLER);
        User vendor1 = UserFactory.createUser(UserType.VENDOR);

        //create orders
        Order order1 = new Order(100.0);
        Order order2 = new Order(50.0);
        Order order3 = new Order(200.0);


        List<Payout> payoutList = new ArrayList<>();

        //create some sample payout objects
        //order 1
        Payout customerPayout1 = new Payout(customer1, 20.0, order1.getId());
        Payout sellerPayout1 = new Payout(seller1, 60.0, order1.getId());
        Payout vendorPayout1 = new Payout(vendor1, 20.0, order1.getId());

        //order2
        Payout customerPayout2 = new Payout(customer1, 10.0, order2.getId());
        Payout sellerPayout2 = new Payout(seller1, 20.0, order2.getId());
        Payout vendorPayout2 = new Payout(vendor1, 20.0, order2.getId());

        //order3
        Payout customerPayout3 = new Payout(customer1, 30.0, order3.getId());
        Payout sellerPayout3 = new Payout(seller1, 120.0, order3.getId());
        Payout vendorPayout3 = new Payout(vendor1, 50.0, order3.getId());

        payoutList.add(customerPayout1);
        payoutList.add(sellerPayout1);
        payoutList.add(vendorPayout1);
        payoutList.add(customerPayout2);
        payoutList.add(sellerPayout2);
        payoutList.add(vendorPayout2);
        payoutList.add(customerPayout3);
        payoutList.add(sellerPayout3);
        payoutList.add(vendorPayout3);

        //call service
        payoutList = payoutControlService.identifyPayoutBankAndMode(payoutList);
    }

}
