import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("tan","nat"),
                Collections.singletonList("bat"),
                Arrays.asList("eat","tea","ate")
        );

        List<List<String>> actual = tested.groupAnagrams(strs);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldWork2() {
        String[] strs = {""};
        List<List<String>> expected = Arrays.asList(
                Collections.singletonList("")
        );

        List<List<String>> actual = tested.groupAnagrams(strs);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldWork3() {
        String[] strs = {"a"};
        List<List<String>> expected = Arrays.asList(
                Collections.singletonList("a")
        );

        List<List<String>> actual = tested.groupAnagrams(strs);

        assertEquals(expected, actual);
    }
}
