import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {

        String s = "ca";
        int expected = 2;

        assertEquals(expected, tested.minimumLength(s));
    }

    @Test
    public void shouldWork2() {

        String s = "cabaabac";
        int expected = 0;

        assertEquals(expected, tested.minimumLength(s));
    }

    @Test
    public void shouldWork3() {

        String s = "aabccabba";
        int expected = 3;

        assertEquals(expected, tested.minimumLength(s));
    }

    @Test
    public void shouldWork4() {

        String s = "bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb";
        int expected = 1;

        assertEquals(expected, tested.minimumLength(s));
    }

    @Test
    public void shouldWork5() {

        String s = "cbc";
        int expected = 1;

        assertEquals(expected, tested.minimumLength(s));
    }
}
