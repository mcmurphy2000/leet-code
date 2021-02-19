import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        assertEquals("210", tested.largestNumber(new int[] {10, 2}));
        assertEquals("9534330", tested.largestNumber(new int[] {3,30,34,5,9}));
        assertEquals("1", tested.largestNumber(new int[] {1}));
        assertEquals("10", tested.largestNumber(new int[] {10}));
        assertEquals("330", tested.largestNumber(new int[] {30,3}));
        assertEquals("1113111311", tested.largestNumber(new int[] {111311, 1113}));
        assertEquals("0", tested.largestNumber(new int[] {0, 0}));
    }
}
