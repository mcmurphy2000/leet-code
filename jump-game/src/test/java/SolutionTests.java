import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork() {
        assertTrue(tested.canJump(new int[] {2,3,1,1,4}));
    }

    @Test
    public void shouldWork1() {
        assertFalse(tested.canJump(new int[] {3,2,1,0,4}));
    }

}
