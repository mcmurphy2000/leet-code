import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork() {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] expected = {{1,6},{8,10},{15,18}};

        assertArrayEquals(expected, tested.merge(intervals));
    }

    @Test
    public void shouldWork1() {
        int[][] intervals = {{1,4},{4,5}};
        int[][] expected = {{1,5}};

        assertArrayEquals(expected, tested.merge(intervals));
    }
}
