import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        int[] nums = {1,2,3};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(2,1,3),
                Arrays.asList(2,3,1),
                Arrays.asList(1,3,2),
                Arrays.asList(3,1,2),
                Arrays.asList(3,2,1)
        );

        assertEquals(expected, tested.permute(nums));
    }

    @Test
    public void shouldWork2() {
        int[] nums = {0,1};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(1,0)
        );

        assertEquals(expected, tested.permute(nums));
    }

    @Test
    public void shouldWork3() {
        int[] nums = {1};
        List<List<Integer>> expected = Collections.singletonList(
                Collections.singletonList(1)
        );

        assertEquals(expected, tested.permute(nums));
    }
}
