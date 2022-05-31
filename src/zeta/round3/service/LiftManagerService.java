package zeta.round3.service;

import zeta.round3.constants.Direction;
import zeta.round3.model.Lift;
import zeta.round3.model.LiftManager;
import zeta.round3.model.Request;

import java.util.List;

public class LiftManagerService {

    private  LiftService liftService;

    private LiftManager liftManager;

    public LiftManagerService(LiftManager liftManager, LiftService liftService) {
        this.liftManager = liftManager;
        this.liftService = liftService;
    }

    public void assignRequest(Request request) {
        List<Lift> availLifts = liftManager.getLiftList();
        int count = availLifts.size();
        int minWaitTime = Integer.MAX_VALUE;
        Lift resultLift = null;

        for (int i = 0; i < count; i++) {
            Lift lift = availLifts.get(i);
            if (liftService.canServeRequest(lift, request)) {
                System.out.println(String.format("Lift %d can serve request for floor %d", i+1, request.getFloorNum()));
                int waitTime = Math.abs(lift.getCurrentFloor() - request.getFloorNum());
                if (waitTime < minWaitTime) {
                    resultLift = lift;
                    minWaitTime = waitTime;
                }
            }
        }

        if (resultLift != null) {
            System.out.println("Lift selected for Request = " + resultLift.getNumber());
            resultLift.addRequest(request);
        } else {
            //if no lift found
            if (request.getDesiredDirection().equals(Direction.DOWN)) {
                liftManager.addToDownWaitingQueue(request);
            } else {
                liftManager.addToUpWaitingQueue(request);
            }
        }

    }

}
