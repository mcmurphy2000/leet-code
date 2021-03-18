import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        int[] prices = {7,1,5,3,6,4};
        int expected = 7;

        assertEquals(expected, tested.maxProfit(prices));
    }

    @Test
    public void shouldWork2() {
        int[] prices = {1,2,3,4,5};
        int expected = 4;

            assertEquals(expected, tested.maxProfit(prices));
    }

    @Test
    public void shouldWork3() {
        int[] prices = {7,6,4,3,1};
        int expected = 0;

        assertEquals(expected, tested.maxProfit(prices));
    }
}
