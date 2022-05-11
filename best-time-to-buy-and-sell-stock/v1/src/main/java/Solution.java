class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] futureMax = new int[n];
        futureMax[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--)
            futureMax[i] = Math.max(futureMax[i + 1], prices[i + 1]);
        int max = 0;
        for (int i = 0; i < n - 1; i++)
            max = Math.max(max, futureMax[i] - prices[i]);
        return max;
    }
}