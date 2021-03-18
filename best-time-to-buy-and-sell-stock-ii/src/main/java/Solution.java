class Solution {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int trade = prices[i] - prices[i - 1];
            if (trade > 0)
                profit += trade;
        }
        return profit;
    }
}