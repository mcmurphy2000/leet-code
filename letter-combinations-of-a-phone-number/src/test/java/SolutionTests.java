import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        String digits = "23";
        List<String> expected = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");

        assertEquals(expected, tested.letterCombinations(digits));
    }

    @Test
    public void shouldWork2() {
        String digits = "";
        List<String> expected = new ArrayList<>();

        assertEquals(expected, tested.letterCombinations(digits));
    }

    @Test
    public void shouldWork3() {
        String digits = "2";
        List<String> expected = Arrays.asList("a","b","c");

        assertEquals(expected, tested.letterCombinations(digits));
    }
}
