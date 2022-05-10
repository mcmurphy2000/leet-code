import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        int[] expected = {1,2,2,3,5,6};

        tested.merge(nums1, m, nums2, n);

        assertArrayEquals(expected, nums1);
    }

    @Test
    public void shouldWork2() {
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        int[] expected = {1};

        tested.merge(nums1, m, nums2, n);

        assertArrayEquals(expected, nums1);
    }

    @Test
    public void shouldWork3() {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        int[] expected = {1};

        tested.merge(nums1, m, nums2, n);

        assertArrayEquals(expected, nums1);
    }
}
