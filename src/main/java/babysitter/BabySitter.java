package babysitter;

import exception.NotAvailableException;

public class BabySitter {

    private int startTime;
    private int endTime;

    public BabySitter() {
        this.startTime = 17;
        this.endTime = 4;
    }

    public BabySitter(int startTime, int endTime) {
        if(startTime < 17 || startTime > 4) {
            throw new NotAvailableException("I'm sorry, I cannot start before 5:00 PM");
        }
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
