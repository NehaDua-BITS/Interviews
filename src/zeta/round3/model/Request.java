package zeta.round3.model;

import zeta.round3.constants.Direction;

public class Request implements Comparable<Request> {

    private int floorNum;

    private Direction desiredDirection;

    public Request(int floorNum) {
        this(floorNum, null);
    }

    public Request(int floorNum, Direction desiredDirection) {
        this.floorNum = floorNum;
        this.desiredDirection = desiredDirection;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    @Override
    public int compareTo(Request o) {
        return this.floorNum - o.getFloorNum();
    }

    public Direction getDesiredDirection() {
        return desiredDirection;
    }

    public void setDesiredDirection(Direction desiredDirection) {
        this.desiredDirection = desiredDirection;
    }
}
