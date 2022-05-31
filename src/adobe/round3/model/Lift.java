package adobe.round3.model;

import adobe.round3.constants.Direction;
import adobe.round3.constants.State;

import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

public class Lift {

    private Direction currentDirection;

    private State state;

    private int currentFloor;

    private TreeSet<Request> currentRequests;

    private List<Request> waitingUpRequests;

    private List<Request> waitingDownRequests;

    public Lift() {
        state = State.IDLE;
        currentFloor = 0;
        currentDirection = Direction.UP;
    }

    public Request getNextRequest() {
        Request nextRequest = null;
        if (currentDirection == Direction.UP) {
            nextRequest = currentRequests.first();
        } else {
            nextRequest = currentRequests.last();
        }
        return nextRequest;
    }

    public void removeRequest(Request request) {
        this.currentRequests.remove(request);
    }

    //assign request
    public void addRequest(Request request) {
        currentRequests.add(request);
    }

    public void addToUpWaitingQueue(Request request) {
        waitingUpRequests.add(request);
    }


    public void addToDownWaitingQueue(Request request) {
        waitingDownRequests.add(request);
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveToNextFloor() {
        this.currentFloor++;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public TreeSet<Request> getCurrentRequests() {
        return currentRequests;
    }

    public void setCurrentRequests(TreeSet<Request> currentRequests) {
        this.currentRequests = currentRequests;
    }

    public List<Request> getWaitingUpRequests() {
        return waitingUpRequests;
    }

    public void setWaitingUpRequests(List<Request> waitingUpRequests) {
        this.waitingUpRequests = waitingUpRequests;
    }

    public List<Request> getWaitingDownRequests() {
        return waitingDownRequests;
    }

    public void setWaitingDownRequests(List<Request> waitingDownRequests) {
        this.waitingDownRequests = waitingDownRequests;
    }
}
