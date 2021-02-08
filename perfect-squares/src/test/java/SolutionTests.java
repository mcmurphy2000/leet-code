import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork() {
        assertEquals(3, tested.numSquares(12));
        assertEquals(2, tested.numSquares(13));
        assertEquals(4, tested.numSquares(7168));
    }
}
