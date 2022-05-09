import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        int[] nums = {1,2,3,1};
        boolean expected = true;

        boolean result = tested.containsDuplicate(nums);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork2() {
        int[] nums = {1,2,3,4};
        boolean expected = false;

        boolean result = tested.containsDuplicate(nums);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork3() {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        boolean expected = true;

        boolean result = tested.containsDuplicate(nums);

        assertEquals(expected, result);
    }
}
