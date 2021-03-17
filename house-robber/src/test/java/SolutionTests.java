import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        int[] nums = {1,2,3,1};
        int expected = 4;

        assertEquals(expected, tested.rob(nums));
    }

    @Test
    public void shouldWork2() {
        int[] nums = {2,7,9,3,1};
        int expected = 12;

        assertEquals(expected, tested.rob(nums));
    }

    @Test
    public void shouldWork3() {
        int[] nums = {1,1,1};
        int expected = 2;

        assertEquals(expected, tested.rob(nums));
    }

    @Test
    public void shouldWork4() {
        int[] nums = {2,7,9,3,1};
        int expected = 12;

        assertEquals(expected, tested.rob(nums));
    }

    @Test
    public void shouldWork5() {
        int[] nums = {183,219,57,193,94,233,202,154,65,240,97,234,100,249,186,66,90,238,168,128,177,235,50,81,185,165,217,207,88,80,112,78,135,62,228,247,211};
        int expected = 3365;

        assertEquals(expected, tested.rob(nums));
    }
}
