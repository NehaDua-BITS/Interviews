package adobe.round1.prodcons;

public class Producer implements Runnable {

    private State state;

    public Producer(State state) {
        this.state = state;
    }

    @Override
    public void run() {
        while (state.currNum < state.max) {
            synchronized (state) {  //used for synchronization
                while (!state.isConsumed) { //used for identifying turn
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }//comes out of wait
                state.incrementNum();
                System.out.println("Produced : " + state.currNum);
                state.isConsumed = false;
                state.notifyAll();
            }
        }
    }
}
