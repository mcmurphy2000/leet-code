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
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] expected = {1, 2};

        assertTrue(Arrays.equals(expected, tested.topKFrequent(nums, k)));
    }

    @Test
    public void shouldWork2() {
        int[] nums = {1};
        int k = 1;
        int[] expected = {1};

        assertTrue(Arrays.equals(expected, tested.topKFrequent(nums, k)));
    }
}
