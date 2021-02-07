import java.util.Arrays;

public class Solution {

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        return binarySearchDuplicate(nums, 0, nums.length);
    }

    // to exclusive
    public int binarySearchDuplicate(int[] nums, int from, int to) {
        if (nums[from] == nums[from + 1]) return nums[from];
        int mid = (from + to) / 2;

        if (nums[mid] < mid + 1) {
            return binarySearchDuplicate(nums, from, mid);
        } else {
            return binarySearchDuplicate(nums, mid, to);
        }


    }
}
