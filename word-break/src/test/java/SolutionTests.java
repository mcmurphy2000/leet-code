import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet","code");

        assertTrue(tested.wordBreak(s, wordDict));
    }

    @Test
    public void shouldWork2() {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple","pen");

        assertTrue(tested.wordBreak(s, wordDict));
    }

    @Test
    public void shouldWork3() {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");

        assertFalse(tested.wordBreak(s, wordDict));
    }
}
