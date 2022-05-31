package adobe.round3.service;

import adobe.round3.constants.Direction;
import adobe.round3.model.Lift;
import adobe.round3.model.Request;

public class LiftService {

    //logic for setting current requests

    //request -> identify queue?

    public boolean canAccomodateRequest(Lift lift, Request request) {

        if (lift.getCurrentDirection() == Direction.UP && request.getFloor() > lift.getCurrentFloor()) {
            return true;
        }

        if (lift.getCurrentDirection() == Direction.DOWN && request.getFloor() < lift.getCurrentFloor()) {
            return true;
        }

        return false;
    }

}
