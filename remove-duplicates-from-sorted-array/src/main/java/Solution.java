class Solution {
    public int removeDuplicates(int[] nums) {
        int pos1 = 0;
        int pos2 = 0;

        while (pos2 < nums.length) {
            if (nums[pos2] > nums[pos1]) {
                pos1++;
                nums[pos1] = nums[pos2];
            }
            pos2++;
        }
        return Math.min(pos1 + 1, nums.length);
    }
}