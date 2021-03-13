import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork() {
        assertEquals(28, tested.uniquePaths(3, 7));
        assertEquals(3, tested.uniquePaths(3, 2));
        assertEquals(28, tested.uniquePaths(7, 3));
        assertEquals(6, tested.uniquePaths(3, 3));
    }

    @Test
    public void shouldWork1() {
        assertEquals(1, tested.uniquePaths(1, 1));
    }

}
