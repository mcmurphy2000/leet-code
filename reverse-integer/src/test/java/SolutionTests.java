import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        int x = 123;
        int expected = 321;

        assertEquals(expected, tested.reverse(x));
    }

    @Test
    public void shouldWork2() {
        int x = -123;
        int expected = -321;

        assertEquals(expected, tested.reverse(x));
    }

    @Test
    public void shouldWork3() {
        int x = 120;
        int expected = 21;

        assertEquals(expected, tested.reverse(x));
    }

    @Test
    public void shouldWork4() {
        int x = 0;
        int expected = 0;

        assertEquals(expected, tested.reverse(x));
    }

    @Test
    public void shouldWork5() {
        int x = 1534236469;
        int expected = 0;

        assertEquals(expected, tested.reverse(x));
    }

    @Test
    public void shouldWork6() {
        int x = -1534236469;
        int expected = 0;

        assertEquals(expected, tested.reverse(x));
    }
}
