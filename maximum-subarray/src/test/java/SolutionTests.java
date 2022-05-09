import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int expected = 6;

        int result = tested.maxSubArray(nums);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork2() {
        int[] nums = {1};
        int expected = 1;

        int result = tested.maxSubArray(nums);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork3() {
        int[] nums = {5,4,-1,7,8};
        int expected = 23;

        int result = tested.maxSubArray(nums);

        assertEquals(expected, result);
    }
}
