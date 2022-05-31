package zeta.round3.service;

import zeta.round3.constants.Direction;
import zeta.round3.model.Lift;
import zeta.round3.model.Request;

public class LiftService {

    public boolean canServeRequest(Lift lift, Request request) {
        //check for capacity & wait time
        if (lift.getMaxCapacity() > lift.getCurrentCapacity() &&
               lift.getCurrentDirection().equals(request.getDesiredDirection())) {
            if (lift.getCurrentDirection() == Direction.UP) {
                return lift.getCurrentFloor() < request.getFloorNum();
            } else {
                return lift.getCurrentFloor() > request.getFloorNum();
            }
        }

        return false;
    }

}
