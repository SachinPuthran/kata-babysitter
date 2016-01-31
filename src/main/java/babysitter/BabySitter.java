package babysitter;

public class BabySitter {

    private int startTime;

    public BabySitter() {
        this.startTime = 17;
    }

    public BabySitter(int startTime) {
        this.startTime = startTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return 4;
    }
}
