import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat","cats","and","sand","dog");
        String[] expected = {"cats and dog","cat sand dog"};

        List<String> actual = tested.wordBreak(s, wordDict);

        assertThat(actual).containsExactlyInAnyOrder(expected);
    }

    @Test
    public void shouldWork2() {
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList("apple","pen","applepen","pine","pineapple");
        String[] expected = {"pine apple pen apple","pineapple pen apple","pine applepen apple"};

        List<String> actual = tested.wordBreak(s, wordDict);

        assertThat(actual).containsExactlyInAnyOrder(expected);
    }

    @Test
    public void shouldWork3() {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");
        String[] expected = {};

        List<String> actual = tested.wordBreak(s, wordDict);

        assertThat(actual).containsExactlyInAnyOrder(expected);
    }
}
