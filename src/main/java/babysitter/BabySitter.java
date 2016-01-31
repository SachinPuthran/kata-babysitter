package babysitter;

public class BabySitter {

    private int startTime;
    private int endTime;

    public BabySitter() {
        this.startTime = 17;
        this.endTime = 4;
    }

    public BabySitter(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}
