import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        int[] nums = {1,3,5,6};
        int target = 5;
        int expected = 2;

        assertEquals(expected, tested.searchInsert(nums, target));
    }

    @Test
    public void shouldWork2() {
        int[] nums = {1,3,5,6};
        int target = 2;
        int expected = 1;

        assertEquals(expected, tested.searchInsert(nums, target));
    }

    @Test
    public void shouldWork3() {
        int[] nums = {1,3,5,6};
        int target = 7;
        int expected = 4;

        assertEquals(expected, tested.searchInsert(nums, target));
    }

    @Test
    public void shouldWork4() {
        int[] nums = {1,3,5,6};
        int target = 0;
        int expected = 0;

        assertEquals(expected, tested.searchInsert(nums, target));
    }
}
