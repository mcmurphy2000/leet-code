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
        assertEquals(3, tested.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, tested.lengthOfLongestSubstring("bbbb"));
        assertEquals(3, tested.lengthOfLongestSubstring("pwwkew"));
        assertEquals(0, tested.lengthOfLongestSubstring(""));
        assertEquals(2, tested.lengthOfLongestSubstring("aab"));
        assertEquals(3, tested.lengthOfLongestSubstring("dvdf"));
    }
}
