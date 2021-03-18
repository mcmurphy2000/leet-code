import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        assertEquals(2, tested.climbStairs(2));
        assertEquals(3, tested.climbStairs(3));
    }
}
