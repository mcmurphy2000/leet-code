import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork() {
        int[] nums = {2,0,2,1,1,0};
        int[] sorted = {0,0,1,1,2,2};

        tested.sortColors(nums);

        assertArrayEquals(sorted, nums);
    }

    @Test
    public void shouldWork1() {
        int[] nums = {2,0,1};
        int[] sorted = {0,1,2};

        tested.sortColors(nums);

        assertArrayEquals(sorted, nums);
    }

    @Test
    public void shouldWork2() {
        int[] nums = {0};
        int[] sorted = {0};

        tested.sortColors(nums);

        assertArrayEquals(sorted, nums);
    }

    @Test
    public void shouldWork3() {
        int[] nums = {1};
        int[] sorted = {1};

        tested.sortColors(nums);

        assertArrayEquals(sorted, nums);
    }
}
