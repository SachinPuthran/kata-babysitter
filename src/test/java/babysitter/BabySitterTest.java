package babysitter;

import static org.junit.Assert.*;

import exception.NotAvailableException;
import org.junit.Test;

public class BabySitterTest {
    @Test
    public void babySitterReturnsStartTimeAs17() {
        BabySitter babySitter = new BabySitter();
        assertEquals(17, babySitter.getStartTime());
    }

    @Test
    public void babySitterAcceptsStartTimeAndReturnsAcceptedStartTime() {
        BabySitter babySitter = new BabySitter(18, 4, BabySitter.DEFAULT_BED_TIME);
        assertEquals(18, babySitter.getStartTime());
    }

    @Test
    public void babySitterReturnsEndTimeAs4() {
        BabySitter babySitter = new BabySitter();
        assertEquals(4, babySitter.getEndTime());
    }

    @Test
    public void babySitterAcceptsEndTimeAndReturnsAcceptedEndTime() {
        BabySitter babySitter = new BabySitter(19, 23, BabySitter.DEFAULT_BED_TIME);
        assertEquals(23, babySitter.getEndTime());
        assertEquals(19, babySitter.getStartTime());
    }

    @Test(expected = NotAvailableException.class)
    public void babySitterDoesNotAcceptInvalidStartTimeAndThrowsNotAvailableException() {
        new BabySitter(12, 2, BabySitter.DEFAULT_BED_TIME);
    }

    @Test
    public void babySitterDoesNotAcceptInvalidStartTimeAndThrowsNotAvailableExceptionWithAnAcceptableMessage() {
        try {
            new BabySitter(5, 4, BabySitter.DEFAULT_BED_TIME);
        } catch (NotAvailableException ex) {
            assertEquals(BabySitter.START_TIME_NOT_AVAILABLE_MESSAGE, ex.getMessage());
        }
    }

    @Test
    public void babySitterDoesNotAcceptInvalidEndTimeAndThrowsNotAvailableExceptionWithAnAcceptableMessage() {
        try {
            new BabySitter(20, 6, BabySitter.DEFAULT_BED_TIME);
            fail("Expecting NotAvailableException to be thrown");
        } catch (NotAvailableException ex) {
            assertEquals(BabySitter.END_TIME_NOT_AVAILABLE_MESSAGE, ex.getMessage());
        }
    }

    @Test
    public void babySitterReturnsDefaultBedTimeAs21() {
        BabySitter babySitter = new BabySitter();
        assertEquals(21, babySitter.getBedTime());
    }

    @Test
    public void babySitterAcceptsBedTimeAndReturnsAcceptedBedTime() {
        int expectedBedTime = 22;
        int expectedEndTime = 2;
        int expectedStartTime = 20;
        BabySitter babySitter = new BabySitter(expectedStartTime, expectedEndTime, expectedBedTime);
        assertEquals(expectedBedTime, babySitter.getBedTime());
    }

    @Test
    public void babySitterCalculatesPaymentFor2HoursTillBedTime() {
        BabySitter babySitter = new BabySitter(19, 21, BabySitter.DEFAULT_BED_TIME);
        assertEquals(BabySitter.RATE_TILL_BED_TIME * 2, babySitter.calculatePayment());
    }

    @Test
    public void babySitterCalculatesPaymentFor3HoursTillBedTime() {
        BabySitter babySitter = new BabySitter(19, 22, 22);
        assertEquals(BabySitter.RATE_TILL_BED_TIME * 3, babySitter.calculatePayment());
    }
}
