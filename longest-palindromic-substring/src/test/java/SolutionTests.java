import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork() {
        assertEquals("bab", tested.longestPalindrome("babad"));
        assertEquals("bb", tested.longestPalindrome("cbbd"));
        assertEquals("a", tested.longestPalindrome("a"));
        assertEquals("a", tested.longestPalindrome("ac"));
    }
}
