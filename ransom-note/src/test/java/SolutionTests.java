import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        String ransomNote = "a";
        String magazine = "b";
        boolean expected = false;

        boolean result = tested.canConstruct(ransomNote, magazine);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork2() {
        String ransomNote = "aa";
        String magazine = "ab";
        boolean expected = false;

        boolean result = tested.canConstruct(ransomNote, magazine);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork3() {
        String ransomNote = "aa";
        String magazine = "aab";
        boolean expected = true;

        boolean result = tested.canConstruct(ransomNote, magazine);

        assertEquals(expected, result);
    }
}
