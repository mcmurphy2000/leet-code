import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork() {
        assertEquals(2, tested.numDecodings("12"));
    }

    @Test
    public void shouldWork1() {
        assertEquals(3, tested.numDecodings("226"));
    }

    @Test
    public void shouldWork2() {
        assertEquals(0, tested.numDecodings("0"));
    }

    @Test
    public void shouldWork3() {
        assertEquals(0, tested.numDecodings("06"));
    }

    @Test
    public void shouldWork4() {
        assertEquals(2, tested.numDecodings("134"));
    }
}
