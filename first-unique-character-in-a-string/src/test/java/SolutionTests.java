import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        String s = "leetcode";
        int expected = 0;

        int result = tested.firstUniqChar(s);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork2() {
        String s = "loveleetcode";
        int expected = 2;

        int result = tested.firstUniqChar(s);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork3() {
        String s = "aabb";
        int expected = -1;

        int result = tested.firstUniqChar(s);

        assertEquals(expected, result);
    }
}
