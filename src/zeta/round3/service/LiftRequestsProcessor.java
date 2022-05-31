package zeta.round3.service;

import zeta.round3.model.Lift;
import zeta.round3.model.Request;

/**
 * Does actual processing of requests
 */
public class LiftRequestsProcessor implements Runnable {

    private Lift lift;

    public LiftRequestsProcessor(Lift lift) {
        this.lift = lift;
    }

    @Override
    public void run() {
        System.out.println(String.format("%s Started. Direction = %s ", Thread.currentThread().getName(), lift.getCurrentDirection()));

        while(true) {
            Request request = lift.getNextRequest();
            System.out.println(String.format("Lift %d => Going to floor number : %d", lift.getCurrentFloor(), request.getFloorNum()));
            lift.removeRequest(request);

            if (lift.getCurrentRequests().size() == 0) {
                System.out.println("Current queue is emptied ! Manager will assign more.");
                break;
            }
        }
    }
}
