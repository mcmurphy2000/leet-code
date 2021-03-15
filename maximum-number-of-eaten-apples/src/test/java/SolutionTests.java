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
        int[] apples = {1,2,3,5,2};
        int[] days = {3,2,1,4,2};
        int expected = 7;

        assertEquals(expected, tested.eatenApples(apples, days));
    }

    @Test
    public void shouldWork1() {
        int[] apples = {3,0,0,0,0,2};
        int[] days = {3,0,0,0,0,2};
        int expected = 5;

        assertEquals(expected, tested.eatenApples(apples, days));
    }
}
