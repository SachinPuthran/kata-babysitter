package babysitter;

import exception.NotAvailableException;

public class BabySitter {

    public static final String START_TIME_NOT_AVAILABLE_MESSAGE = "I'm sorry, I cannot start before 5:00 PM";

    public static final int EARLIEST_START_TIME = 17;
    public static final int MAX_END_TIME = 4;

    private int startTime;
    private int endTime;

    public BabySitter() {
        this.startTime = EARLIEST_START_TIME;
        this.endTime = MAX_END_TIME;
    }

    public BabySitter(int startTime, int endTime) {
        if(startTime < EARLIEST_START_TIME && startTime > MAX_END_TIME) {
            throw new NotAvailableException(START_TIME_NOT_AVAILABLE_MESSAGE);
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
