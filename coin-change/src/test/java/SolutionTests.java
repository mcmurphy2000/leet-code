import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork() {
        assertEquals(3, tested.coinChange(new int[] {1, 2, 5}, 11));
        assertEquals(-1, tested.coinChange(new int[] {2}, 3));
        assertEquals(0, tested.coinChange(new int[] {1}, 0));
        assertEquals(1, tested.coinChange(new int[] {1}, 1));
        assertEquals(2, tested.coinChange(new int[] {1}, 2));
    }
}
