import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        String s = "anagram";
        String t = "nagaram";
        boolean expected = true;

        boolean result = tested.isAnagram(s, t);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork2() {
        String s = "rat";
        String t = "car";
        boolean expected = false;

        boolean result = tested.isAnagram(s, t);

        assertEquals(expected, result);
    }
}
