package adobe.round3.model;

import java.util.List;

public class LiftManager {

    private List<Lift> liftList;

    public LiftManager(List<Lift> liftList) {
        this.liftList = liftList;
    }

    public List<Lift> getLifts() {
        return liftList; //working lifts
    }

    public void setLiftList(List<Lift> liftList) {
        this.liftList = liftList;
    }
}
