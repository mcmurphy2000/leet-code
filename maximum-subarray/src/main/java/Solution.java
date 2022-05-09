class Solution {
    public int maxSubArray(int[] nums) {
        int cur = 0;
        int min = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(cur, min);
            cur += num;
            maxSum = Math.max(maxSum, cur - min);
        }
        return maxSum;
    }
}