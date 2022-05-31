package adobe.round1.prodcons;

public class Consumer implements Runnable {

    private State state;

    public Consumer(State state) {
        this.state = state;
    }

    @Override
    public void run() {
        while (state.currNum < state.max) {
            synchronized(state) {
                while (state.isConsumed) {
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consumed : " + state.currNum);
                state.isConsumed = true;
                state.notifyAll();
            }
        }
    }
}
