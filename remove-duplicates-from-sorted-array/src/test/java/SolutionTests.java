import org.junit.Test;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        int[] nums = {1,1,2};
        int[] expected = {1,2,0};

        int k = tested.removeDuplicates(nums);

        assertNums(expected, nums, k);
    }

    @Test
    public void shouldWork2() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] expected = {0,1,2,3,4,0,0,0,0,0};

        int k = tested.removeDuplicates(nums);

        assertNums(expected, nums, k);
    }

    @Test
    public void shouldWork3() {
        int[] nums = {0};
        int[] expected = {0};

        int k = tested.removeDuplicates(nums);

        assertNums(expected, nums, k);
    }

    @Test
    public void shouldWork4() {
        int[] nums = {};
        int[] expected = {};

        int k = tested.removeDuplicates(nums);

        assertNums(expected, nums, k);
    }

    private void assertNums(int[] expected, int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            assert nums[i] == expected[i];
        }
    }
}
