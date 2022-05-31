package adobe.round3.service;

import adobe.round3.constants.Direction;
import adobe.round3.model.Lift;
import adobe.round3.model.Request;

import java.util.List;

public class ProcessRequests {

    public void process(Lift lift) {

        while(true) {
            Request nextRequest = lift.getNextRequest();

            while (lift.getCurrentFloor() < nextRequest.getFloor()) {
                //move lift
                lift.moveToNextFloor();
            }

            //remove processed request
            lift.removeRequest(nextRequest);

            //check if any waiting requests and add to cuurent queue
            if (lift.getCurrentRequests().size() == 0) {
                if (lift.getCurrentDirection() == Direction.UP && lift.getWaitingDownRequests().size() > 0) {
                    lift.getCurrentRequests().addAll(lift.getWaitingDownRequests()); //todo change
                } else if (lift.getCurrentDirection() == Direction.DOWN && lift.getWaitingUpRequests().size() > 0){
                    lift.getCurrentRequests().addAll(lift.getWaitingUpRequests());
                }
            }

            //no more requests left
            if (lift.getCurrentRequests().size() == 0) {
                break;
            }
        }

    }

}
