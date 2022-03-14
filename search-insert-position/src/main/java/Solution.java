class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length);
    }

    /**
     * @param start inclusive
     * @param end exclusive
     */
    private int binarySearch(int[] nums, int target, int start, int end) {
        int mid = (start + end) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            if (end - start <= 1) return mid;
            return binarySearch(nums, target, start, mid);
        } else {
            if (end - start <= 1) return mid + 1;
            return binarySearch(nums, target, mid, end);
        }
    }
}