import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        int n = 3;
        int expected = 5;

        assertEquals(expected, tested.numTrees(n));
    }

    @Test
    public void shouldWork2() {
        int n = 2;
        int expected = 1;

        assertEquals(expected, tested.numTrees(n));
    }
}
