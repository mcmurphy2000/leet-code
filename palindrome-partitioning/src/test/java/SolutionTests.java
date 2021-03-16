import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        String s = "aab";
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a","a","b"),
                Arrays.asList("aa","b")
        );

        assertEquals(expected, tested.partition(s));
    }

    @Test
    public void shouldWork2() {
        String s = "a";
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a")
        );

        assertEquals(expected, tested.partition(s));
    }
}
