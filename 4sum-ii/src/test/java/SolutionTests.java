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
        int[] a = {1, 2};
        int[] b = {-2,-1};
        int[] c = {-1, 2};
        int[] d = {0, 2};

        assertEquals(2, tested.fourSumCount(a, b, c, d));
    }
}
