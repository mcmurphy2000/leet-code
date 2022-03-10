import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        int x = 121;

        assertTrue(tested.isPalindrome(x));
    }

    @Test
    public void shouldWork2() {
        int x = -121;

        assertFalse(tested.isPalindrome(x));
    }

    @Test
    public void shouldWork3() {
        int x = 10;

        assertFalse(tested.isPalindrome(x));
    }
}
