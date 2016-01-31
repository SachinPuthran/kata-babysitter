package babysitter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BabySitterTest {
    @Test
    public void babySitterReturnsStartTimeAs17() {
        BabySitter babySitter = new BabySitter();
        assertEquals(17, babySitter.getStartTime());
    }

    @Test
    public void babySitterAcceptsStartTimeAndReturnsAcceptedStartTime() {
        BabySitter babySitter = new BabySitter(18, 4);
        assertEquals(18, babySitter.getStartTime());
    }

    @Test
    public void babySitterReturnsEndTimeAs4() {
        BabySitter babySitter = new BabySitter();
        assertEquals(4, babySitter.getEndTime());
    }

    @Test
    public void babySitterAcceptsEndTimeAndReturnsAcceptedEndTime() {
        BabySitter babySitter = new BabySitter(19, 11);
        assertEquals(11, babySitter.getEndTime());
        assertEquals(19, babySitter.getStartTime());
    }
}