import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        String s = "()";

        assertTrue(tested.isValid(s));
    }

    @Test
    public void shouldWork2() {
        String s = "()[]{}";

        assertTrue(tested.isValid(s));
    }

    @Test
    public void shouldWork3() {
        String s = "(]";

        assertFalse(tested.isValid(s));
    }

    @Test
    public void shouldWork4() {
        String s = "([)]";

        assertFalse(tested.isValid(s));
    }

    @Test
    public void shouldWork5() {
        String s = "{[]}";

        assertTrue(tested.isValid(s));
    }

    @Test
    public void shouldWork6() {
        String s = "[";

        assertFalse(tested.isValid(s));
    }

    @Test
    public void shouldWork7() {
        String s = "]";

        assertFalse(tested.isValid(s));
    }
}
