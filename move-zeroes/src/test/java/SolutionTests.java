import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        int[] nums = {0,1,0,3,12};
        int[] expected = {1,3,12,0,0};

        tested.moveZeroes(nums);

        assertArrayEquals(expected, nums);
    }

    @Test
    public void shouldWork2() {
        int[] nums = {0};
        int[] expected = {0};

        tested.moveZeroes(nums);

        assertArrayEquals(expected, nums);
    }
}
