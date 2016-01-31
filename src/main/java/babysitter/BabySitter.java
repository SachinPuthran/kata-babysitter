package babysitter;

import exception.NotAvailableException;

public class BabySitter {

    public static final String START_TIME_NOT_AVAILABLE_MESSAGE = "I'm sorry, I cannot start before 5:00 PM";
    public static final String END_TIME_NOT_AVAILABLE_MESSAGE = "I'm sorry, I cannot stay after 4:00 AM";

    public static final int EARLIEST_START_TIME = 17;
    public static final int MAX_END_TIME = 4;
    public static final int DEFAULT_BED_TIME = 21;

    private int startTime;
    private int endTime;
    private int bedTime;

    private PaymentCalculator paymentCalculator;

    public BabySitter() {
        startTime = EARLIEST_START_TIME;
        endTime = MAX_END_TIME;
        bedTime = DEFAULT_BED_TIME;
        paymentCalculator = new PaymentCalculator(startTime, endTime, bedTime);
    }

    public BabySitter(int startTime, int endTime, int bedTime) {
        validateBabySittingTime(startTime, endTime);
        this.startTime = startTime;
        this.endTime = endTime;
        this.bedTime = bedTime;
        paymentCalculator = new PaymentCalculator(startTime, endTime, bedTime);
    }

    private void validateBabySittingTime(int startTime, int endTime) {
        if (startTime < EARLIEST_START_TIME && startTime > MAX_END_TIME) {
            throw new NotAvailableException(START_TIME_NOT_AVAILABLE_MESSAGE);
        } else if (endTime < EARLIEST_START_TIME && endTime > MAX_END_TIME) {
            throw new NotAvailableException(END_TIME_NOT_AVAILABLE_MESSAGE);
        }
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getBedTime() {
        return bedTime;
    }

    public int calculatePayment() {
        return paymentCalculator.calculate();
    }
}
