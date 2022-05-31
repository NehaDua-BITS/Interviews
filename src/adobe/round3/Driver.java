package adobe.round3;

import adobe.round3.constants.Direction;
import adobe.round3.model.*;
import adobe.round3.service.LiftManagerService;
import adobe.round3.service.LiftService;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {

        Driver driver = new Driver();
        //assign lift to manager
        LiftManager liftManager = new LiftManager(driver.initLifts());

        Request request1 = new Request(2);
        Request request2 = new Request(5);
        Request request3 = new Request(2);


        LiftManagerService liftManagerService = new LiftManagerService(liftManager, new LiftService());
        liftManagerService.assignRequest(request1);
        liftManagerService.assignRequest(request2);
        liftManagerService.assignRequest(request3);
    }

    private List<Lift> initLifts() {
        //creating set of lifts
        Lift lift1 = new Lift();
        Lift lift2 = new Lift();
        Lift lift3 = new Lift();
        Lift lift4 = new Lift();

        List<Lift> liftList = new ArrayList<>();
        liftList.add(lift1);
        liftList.add(lift2);
        liftList.add(lift3);
        liftList.add(lift4);

        return liftList;
    }


}
