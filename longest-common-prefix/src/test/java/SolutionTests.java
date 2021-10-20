import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        String[] strs = { "flower","flow","flight" };
        var expected = "fl";

        assertEquals(expected, tested.longestCommonPrefix(strs));
    }

    @Test
    public void shouldWork2() {
        String[] strs = { "dog","racecar","car" };
        var expected = "";

        assertEquals(expected, tested.longestCommonPrefix(strs));
    }
}
