import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        int numRows = 5;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1,1),
                Arrays.asList(1,2,1),
                Arrays.asList(1,3,3,1),
                Arrays.asList(1,4,6,4,1)
        );

        assertEquals(expected, tested.generate(numRows));
    }

    @Test
    public void shouldWork2() {
        int numRows = 1;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1)
        );

        assertEquals(expected, tested.generate(numRows));
    }
}
