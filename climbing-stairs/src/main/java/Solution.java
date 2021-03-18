class Solution {

    public int climbStairs(int n) {
        // recursive
//        if (n < 0) return 0;
//        if (n == 0) return 1;
//        return climbStairs(n - 1) + climbStairs(n - 2);

        // iterative
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        int i = 2;
        while (i <= n) {
            dp[i] = dp[i - 1] + dp[i - 2];
            i++;
        }
        return dp[n];
    }
}