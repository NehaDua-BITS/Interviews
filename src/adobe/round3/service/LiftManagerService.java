package adobe.round3.service;

import adobe.round3.constants.Direction;
import adobe.round3.model.Lift;
import adobe.round3.model.LiftManager;
import adobe.round3.model.Request;

import java.util.List;

public class LiftManagerService {

    private LiftManager liftManager;

    private LiftService liftService;

    public LiftManagerService(LiftManager liftManager, LiftService liftService) {
        this.liftManager = liftManager;
        this.liftService = liftService;
    }

    public void assignRequest(Request request) {

        List<Lift> availLifts = liftManager.getLifts();
        int liftsCount = availLifts.size();

        for (int i = 0; i < liftsCount; i++) {
            if (liftService.canAccomodateRequest(availLifts.get(i), request)) {
                availLifts.get(i).addRequest(request); //assigning to first found lift
                return;
            }
        }

        Lift firstLift = availLifts.get(0);
        if (firstLift.getCurrentDirection() == Direction.DOWN) {
            firstLift.addToUpWaitingQueue(request);
        } else {
            firstLift.addToDownWaitingQueue(request);
        }
    }

}
