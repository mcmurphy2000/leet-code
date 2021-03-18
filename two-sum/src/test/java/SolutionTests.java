import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] expected = {0,1};

        assertArrayEquals(expected, tested.twoSum(nums, target));
    }

    @Test
    public void shouldWork2() {
        int[] nums = {3,2,4};
        int target = 6;
        int[] expected = {1,2};

        assertArrayEquals(expected, tested.twoSum(nums, target));
    }

    @Test
    public void shouldWork3() {
        int[] nums = {3,3};
        int target = 6;
        int[] expected = {0,1};

        assertArrayEquals(expected, tested.twoSum(nums, target));
    }
}
