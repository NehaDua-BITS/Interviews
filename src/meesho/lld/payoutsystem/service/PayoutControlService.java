package meesho.lld.payoutsystem.service;

import meesho.lld.payoutsystem.model.Payout;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PayoutControlService {

    //optional
    Map<UUID, List<Payout>> aggregate(List<Payout> payouts);

    //optional
    List<Payout> identifyPayoutBankAndMode(List<Payout> payouts);

    Payout identifyPayoutBankAndMode(Payout payout);

}
