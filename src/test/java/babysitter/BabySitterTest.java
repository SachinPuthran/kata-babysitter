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
        BabySitter babySitter = new BabySitter(18);
        assertEquals(18, babySitter.getStartTime());
    }
}
