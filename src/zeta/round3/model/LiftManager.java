package zeta.round3.model;

import java.util.ArrayList;
import java.util.List;

public class LiftManager {

    private List<Lift> liftList;

    private List<Request> upWaitingRequests;

    private List<Request> downWaitingRequests;

    public LiftManager() {
        this.upWaitingRequests = new ArrayList<>();
        this.downWaitingRequests = new ArrayList<>();
    }

    public LiftManager(List<Lift> liftList) {
        this.liftList = liftList;
    }

    public List<Lift> getLiftList() {
        return liftList;
    }

    public void setLiftList(List<Lift> liftList) {
        this.liftList = liftList;
    }

    public void addLift(Lift lift) {
        this.liftList.add(lift); //todo null check
    }

    public void addToUpWaitingQueue(Request request) {
        upWaitingRequests.add(request);
    }

    public void addToDownWaitingQueue(Request request) {
        downWaitingRequests.add(request);
    }

}
