import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {

        int[][] graph = {{1,2},{3},{3},{}};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0,1,3),
                Arrays.asList(0,2,3)
        );

        List<List<Integer>> actual = tested.allPathsSourceTarget(graph);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldWork2() {
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0,4),
                Arrays.asList(0,3,4),
                Arrays.asList(0,1,3,4),
                Arrays.asList(0,1,2,3,4),
                Arrays.asList(0,1,4)
        );

        List<List<Integer>> actual = tested.allPathsSourceTarget(graph);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldWork3() {
        int[][] graph = {{1},{}};
        List<List<Integer>> expected = Collections.singletonList(
                Arrays.asList(0, 1)
        );

        List<List<Integer>> actual = tested.allPathsSourceTarget(graph);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldWork4() {
        int[][] graph = {{1,2,3},{2},{3},{}};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0,1,2,3),
                Arrays.asList(0,2,3),
                Arrays.asList(0,3)
        );

        List<List<Integer>> actual = tested.allPathsSourceTarget(graph);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldWork5() {
        int[][] graph = {{1,3},{2},{3},{}};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0,1,2,3),
                Arrays.asList(0,3)
        );

        List<List<Integer>> actual = tested.allPathsSourceTarget(graph);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldWork6() {
        int[][] graph = {{4,3,1},{3,2,4},{},{4},{}};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0,4),
                Arrays.asList(0,3,4),
                Arrays.asList(0,1,3,4),
                Arrays.asList(0,1,4)
        );

        List<List<Integer>> actual = tested.allPathsSourceTarget(graph);

        assertEquals(expected, actual);
    }
}
