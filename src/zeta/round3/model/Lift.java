package zeta.round3.model;

import zeta.round3.constants.Direction;
import zeta.round3.constants.State;

import java.util.TreeSet;

public class Lift {

    private int number;

    private int currentFloor;

    private Direction currentDirection;

    private TreeSet<Request> currentRequests;

    private State currentState;

    private int maxCapacity;

    private int currentCapacity;

    public Lift(int number, int maxCapacity) {
        this.number = number;
        this.currentFloor = 0;
        this.currentDirection = Direction.UP;
        this.currentRequests = new TreeSet<>();
        this.currentState = State.IDLE;
        this.maxCapacity = maxCapacity;
    }

    public Request getNextRequest() {
        if (currentDirection == Direction.UP) {
            return currentRequests.first();
        } else {
            return currentRequests.last();
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void addRequest(Request request) {
        currentRequests.add(request);
        this.currentCapacity++;
    }

    public void removeRequest(Request request) {
        currentRequests.remove(request);
        this.currentCapacity--;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public TreeSet<Request> getCurrentRequests() {
        return currentRequests;
    }

    public void setCurrentRequests(TreeSet<Request> currentRequests) {
        this.currentRequests = currentRequests;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }
}
