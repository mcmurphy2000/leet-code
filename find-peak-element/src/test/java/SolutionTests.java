import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        int[] nums = {1,2,3,1};
        int expected = 2;

        assertEquals(expected, tested.findPeakElement(nums));
    }

    @Test
    public void shouldWork2() {
        int[] nums = {1,2,1,3,5,6,4};
        int expected = 5;

        assertEquals(expected, tested.findPeakElement(nums));
    }

    @Test
    public void shouldWork3() {
        int[] nums = {1,2,3,4,5};
        int expected = 4;

        assertEquals(expected, tested.findPeakElement(nums));
    }

    @Test
    public void shouldWork4() {
        int[] nums = {1};
        int expected = 0;

        assertEquals(expected, tested.findPeakElement(nums));
    }

    @Test
    public void shouldWork5() {
        int[] nums = {1,2};
        int expected = 1;

        assertEquals(expected, tested.findPeakElement(nums));
    }

    @Test
    public void shouldWork6() {
        int[] nums = {5,2};
        int expected = 0;

        assertEquals(expected, tested.findPeakElement(nums));
    }
}
