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
                Collections.emptyList(),
                Collections.singletonList(3),
                Collections.singletonList(2),
                Arrays.asList(3, 2),
                Collections.singletonList(1),
                Arrays.asList(3, 1),
                Arrays.asList(2, 1),
                Arrays.asList(3, 2, 1)
        );

        assertEquals(expected, tested.subsets(nums));
    }

    @Test
    public void shouldWork2() {
        int[] nums = {0};
        List<List<Integer>> expected = Arrays.asList(
                Collections.emptyList(),
                Collections.singletonList(0)
        );

        assertEquals(expected, tested.subsets(nums));
    }
}
