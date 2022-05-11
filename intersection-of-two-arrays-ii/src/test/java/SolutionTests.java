import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] expected = {2,2};

        assertThat(tested.intersect(nums1, nums2)).containsExactlyInAnyOrder(expected);
    }

    @Test
    public void shouldWork2() {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] expected = {4,9};

        assertThat(tested.intersect(nums1, nums2)).containsExactlyInAnyOrder(expected);
    }
}
