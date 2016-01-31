package babysitter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PaymentCalculatorTest {

    @Test
    public void babySitterCalculatesPaymentFor2HoursTillBedTime() {
        PaymentCalculator paymentCalculator = new PaymentCalculator(19, 21, BabySitter.DEFAULT_BED_TIME);
        assertEquals(PaymentCalculator.RATE_TILL_BED_TIME * 2, paymentCalculator.calculate());
    }

    @Test
    public void babySitterCalculatesPaymentFor3HoursTillBedTime() {
        PaymentCalculator paymentCalculator = new PaymentCalculator(19, 22, 22);
        assertEquals(PaymentCalculator.RATE_TILL_BED_TIME * 3, paymentCalculator.calculate());
    }

    @Test
    public void babySitterCalculatesPaymentFromStartTillMidnight() {
        PaymentCalculator paymentCalculator = new PaymentCalculator(19, 0, 22);
        assertEquals(PaymentCalculator.RATE_TILL_BED_TIME * 3 +
                PaymentCalculator.RATE_BED_TIME_TILL_MIDNIGHT * 2, paymentCalculator.calculate());
    }

    @Test
    public void babySitterCalculatesPaymentFromStartTillBeforeBedTime() {
        PaymentCalculator paymentCalculator = new PaymentCalculator(18, 20, 21);
        assertEquals(PaymentCalculator.RATE_TILL_BED_TIME * 2, paymentCalculator.calculate());
    }

    @Test
    public void babySitterCanCalculatePaymentForFullDefaultHours() {
        PaymentCalculator paymentCalculator = new PaymentCalculator(BabySitter.EARLIEST_START_TIME, BabySitter.MAX_END_TIME, BabySitter.DEFAULT_BED_TIME);
        assertEquals(PaymentCalculator.RATE_TILL_BED_TIME * 4 +
                PaymentCalculator.RATE_BED_TIME_TILL_MIDNIGHT * 3 +
                PaymentCalculator.RATE_MIDNIGHT_TILL_END * 4, paymentCalculator.calculate());
    }

    @Test
    public void babySitterCalculatesPaymentForStartTillEnd() {
        PaymentCalculator paymentCalculator = new PaymentCalculator(20, 1, 21);
        assertEquals(PaymentCalculator.RATE_TILL_BED_TIME +
                PaymentCalculator.RATE_BED_TIME_TILL_MIDNIGHT * 3 +
                PaymentCalculator.RATE_MIDNIGHT_TILL_END, paymentCalculator.calculate());
    }
}
