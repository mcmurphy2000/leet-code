class Solution {

    public int rob(int[] nums) {
        int[] maxs = new int[nums.length];
        int i = 0;
        while (i < nums.length) {
            int prev = i < 1 ? 0 : maxs[i - 1];
            int prevPrev = i < 2 ? 0 : maxs[i - 2];
            int max = Math.max(nums[i] + prevPrev, prev);
            maxs[i] = max;
            i++;
        }
        return maxs[maxs.length - 1];
    }
}