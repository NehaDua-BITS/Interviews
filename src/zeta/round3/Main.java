package zeta.round3;

import zeta.round3.constants.Direction;
import zeta.round3.model.Lift;
import zeta.round3.model.LiftManager;
import zeta.round3.model.Request;
import zeta.round3.service.LiftManagerService;
import zeta.round3.service.LiftRequestsProcessor;
import zeta.round3.service.LiftService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Main obj = new Main();
        List<Lift> liftList = obj.initLifts();
        LiftManager liftManager = new LiftManager(liftList);

        Request request1 = new Request(2, Direction.UP);
        Request request2 = new Request(5, Direction.UP);
        Request request3 = new Request(1, Direction.DOWN);

        LiftManagerService liftManagerService = new LiftManagerService(liftManager, new LiftService());
        liftManagerService.assignRequest(request1);
        liftManagerService.assignRequest(request2);
        liftManagerService.assignRequest(request3);

        LiftRequestsProcessor processor1 = new LiftRequestsProcessor(liftList.get(0));
        Thread thread1 = new Thread(processor1, "lift1");

        LiftRequestsProcessor processor2 = new LiftRequestsProcessor(liftList.get(1));
        Thread thread2 = new Thread(processor1, "lift2");

        LiftRequestsProcessor processor3 = new LiftRequestsProcessor(liftList.get(2));
        Thread thread3 = new Thread(processor1, "lift3");

        Thread.sleep(2000);

        System.out.println("Starting processing threads");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    private List<Lift> initLifts() {
        List<Lift> list = new ArrayList<>();
        Lift lift1 = new Lift(1, 10);

        Lift lift2 = new Lift(2, 2);

        Lift lift3 = new Lift(3,5);
        lift3.setCurrentDirection(Direction.DOWN);
        lift3.setCurrentFloor(2);


        list.add(lift1);
        list.add(lift2);
        list.add(lift3);

        return list;
    }
}
