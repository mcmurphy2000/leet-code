import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork() {
        int[] nums = {1,3,4,2,2};

        assertEquals(2, tested.findDuplicate(nums));
    }

    @Test
    public void shouldWork2() {
        int[] nums = {3,1,3,4,2};

        assertEquals(3, tested.findDuplicate(nums));
    }

    @Test
    public void shouldWork3() {
        int[] nums = {1,1};

        assertEquals(1, tested.findDuplicate(nums));
    }

    @Test
    public void shouldWork4() {
        int[] nums = {1,1,2};

        assertEquals(1, tested.findDuplicate(nums));
    }
}
