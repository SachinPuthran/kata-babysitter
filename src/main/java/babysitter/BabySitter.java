package babysitter;

import exception.NotAvailableException;

public class BabySitter {

    public static final String START_TIME_NOT_AVAILABLE_MESSAGE = "I'm sorry, I cannot start before 5:00 PM";
    public static final String END_TIME_NOT_AVAILABLE_MESSAGE = "I'm sorry, I cannot stay after 4:00 AM";

    public static final int EARLIEST_START_TIME = 17;
    public static final int MAX_END_TIME = 4;
    public static final int DEFAULT_BED_TIME = 21;

    public static final int RATE_TILL_BED_TIME = 12;
    public static final int RATE_BED_TIME_TILL_MIDNIGHT = 8;
    public static final int RATE_MIDNIGHT_TILL_END = 16;

    private int startTime;
    private int endTime;
    private int bedTime;

    private int startTimeForCalc;
    private int endTimeForCalc;
    private int bedTimeForCalc;

    public BabySitter() {
        this.startTime = EARLIEST_START_TIME;
        this.endTime = MAX_END_TIME;
        this.bedTime = DEFAULT_BED_TIME;
        setTimeForCalculation();
    }

    public BabySitter(int startTime, int endTime, int bedTime) {
        validateBabySittingTime(startTime, endTime);
        this.startTime = startTime;
        this.endTime = endTime;
        this.bedTime = bedTime;
        setTimeForCalculation();
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
        return RATE_TILL_BED_TIME * getHoursTillBedTime() +
                RATE_BED_TIME_TILL_MIDNIGHT * getHoursBetweenBedTimeAndMidnight() +
                RATE_MIDNIGHT_TILL_END * getHoursBetweenMidnightAndEnd();
    }

    private int getHoursBetweenBedTimeAndMidnight() {
        if (endTimeForCalc < bedTimeForCalc) {
            return 0;
        }
        if (endTimeForCalc < 24) {
            return endTimeForCalc - bedTimeForCalc;
        }
        return 24 - bedTimeForCalc;
    }

    private int getHoursTillBedTime() {
        if (endTimeForCalc < bedTimeForCalc) {
            return endTimeForCalc - startTimeForCalc;
        }
        return bedTimeForCalc - startTimeForCalc;
    }

    private int getHoursBetweenMidnightAndEnd() {
        if (endTimeForCalc <= 24) {
            return 0;
        }
        return endTimeForCalc - 24;
    }

    private void setTimeForCalculation() {
        this.bedTimeForCalc = adjustTimeFor24HourFormatForCalculation(bedTime);
        this.startTimeForCalc = adjustTimeFor24HourFormatForCalculation(startTime);
        this.endTimeForCalc = adjustTimeFor24HourFormatForCalculation(endTime);
    }

    private int adjustTimeFor24HourFormatForCalculation(int hour) {
        if (hour >= 0 && hour <= 4) {
            hour += 24;
        }
        return hour;
    }
}
