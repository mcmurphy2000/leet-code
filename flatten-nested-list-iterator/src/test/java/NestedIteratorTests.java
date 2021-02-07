import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NestedIteratorTests {

    @Test
    public void shouldWork() {

        // [[1,1],2,[1,1]]
        List<NestedInteger> list1 = Arrays.asList(new NestedIntegerImpl(1), new NestedIntegerImpl(1));
        List<NestedInteger> list2 = Arrays.asList(new NestedIntegerImpl(1), new NestedIntegerImpl(1));
        List<NestedInteger> list = Arrays.asList(new NestedIntegerImpl(list1), new NestedIntegerImpl(2), new NestedIntegerImpl(list2));

        List<Integer> result = new ArrayList<>();
        NestedIterator tested = new NestedIterator(list);
        while (tested.hasNext()) {
            result.add(tested.next());
        }

        assertEquals(Arrays.asList(1, 1, 2, 1, 1), result);
    }

    @Test
    public void shouldWork2() {

        // [1,[4,[6]]]
        List<NestedInteger> list3 = Arrays.asList(new NestedIntegerImpl(6));
        List<NestedInteger> list2 = Arrays.asList(new NestedIntegerImpl(4), new NestedIntegerImpl(list3));
        List<NestedInteger> list1 = Arrays.asList(new NestedIntegerImpl(1), new NestedIntegerImpl(list2));

        List<Integer> result = new ArrayList<>();
        NestedIterator tested = new NestedIterator(list1);
        while (tested.hasNext()) {
            result.add(tested.next());
        }

        assertEquals(Arrays.asList(1, 4, 6), result);
    }

    @Test
    public void shouldWork3() {

        // [[]]
        List<NestedInteger> list = Arrays.asList(new NestedIntegerImpl(new ArrayList<>()));

        List<Integer> result = new ArrayList<>();
        NestedIterator tested = new NestedIterator(list);
        while (tested.hasNext()) {
            result.add(tested.next());
        }

        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void shouldWork4() {

        // [[],[3]]
        List<NestedInteger> list1 = Arrays.asList(new NestedIntegerImpl(new ArrayList<>()));
        List<NestedInteger> list2 = Arrays.asList(new NestedIntegerImpl(3));
        List<NestedInteger> list = Arrays.asList(new NestedIntegerImpl(list1), new NestedIntegerImpl(list2));

        List<Integer> result = new ArrayList<>();
        NestedIterator tested = new NestedIterator(list);
        while (tested.hasNext()) {
            result.add(tested.next());
        }

        assertEquals(Arrays.asList(3), result);
    }



}
