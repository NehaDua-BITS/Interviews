package adobe.round1.prodcons;

public class State {

    int currNum;

    int max;

    boolean isConsumed;

    public State(int startValue, int max) {
        this.isConsumed = true; //to start with production first
        this.currNum = startValue;
        this.max = max;
    }

    public void incrementNum(){
        this.currNum++;
    }

    public void setIsConsumed(boolean isConsumed) {
        this.isConsumed = isConsumed;
    }
}
