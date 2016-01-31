package babysitter;

public class PaymentCalculator {

    public static final int RATE_TILL_BED_TIME = 12;
    public static final int RATE_BED_TIME_TILL_MIDNIGHT = 8;
    public static final int RATE_MIDNIGHT_TILL_END = 16;

    private int startTime;
    private int endTime;
    private int bedTime;

    public PaymentCalculator(int startTime, int endTime, int bedTime) {
        this.bedTime = adjustTimeFor24HourFormatForCalculation(bedTime);
        this.startTime = adjustTimeFor24HourFormatForCalculation(startTime);
        this.endTime = adjustTimeFor24HourFormatForCalculation(endTime);
    }

    private int adjustTimeFor24HourFormatForCalculation(int hour) {
        if (hour >= 0 && hour <= 4) {
            hour += 24;
        }
        return hour;
    }

    public int calculate() {
        return RATE_TILL_BED_TIME * getHoursTillBedTime() +
                RATE_BED_TIME_TILL_MIDNIGHT * getHoursBetweenBedTimeAndMidnight() +
                RATE_MIDNIGHT_TILL_END * getHoursBetweenMidnightAndEnd();
    }

    private int getHoursBetweenBedTimeAndMidnight() {
        if (endTime < bedTime) {
            return 0;
        }
        if (endTime < 24) {
            return endTime - bedTime;
        }
        return 24 - bedTime;
    }

    private int getHoursTillBedTime() {
        if (endTime < bedTime) {
            return endTime - startTime;
        }
        return bedTime - startTime;
    }

    private int getHoursBetweenMidnightAndEnd() {
        if (endTime <= 24) {
            return 0;
        }
        return endTime - 24;
    }
}
