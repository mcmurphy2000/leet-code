import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        int[] prices = {7,1,5,3,6,4};
        int expected = 5;

        assertEquals(expected, tested.maxProfit(prices));
    }

    @Test
    public void shouldWork2() {
        int[] prices = {7,6,4,3,1};
        int expected = 0;

        assertEquals(expected, tested.maxProfit(prices));
    }
}
