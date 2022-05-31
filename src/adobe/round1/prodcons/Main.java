package adobe.round1.prodcons;

public class Main {

    public static void main(String[] args) {

        State state = new State(0, 10);
        Producer producer = new Producer(state);
        Consumer consumer = new Consumer(state);

        Thread prodThread = new Thread(producer);
        Thread consThread = new Thread(consumer);

        prodThread.start();
        consThread.start();
    }
}
