package adobe.round3.model;

public class Request implements Comparable<Request> {

    private Integer floor;

    public Request(Integer floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public int compareTo(Request o) {
        return this.floor - o.getFloor();
    }
}
