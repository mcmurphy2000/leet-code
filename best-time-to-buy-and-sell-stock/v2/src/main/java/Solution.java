class Solution {

    public int maxProfit(int[] prices) {
       int min = Integer.MAX_VALUE;
       int maxProfit = 0;
       for (int price : prices) {
           maxProfit = Math.max(maxProfit, price - min);
           min = Math.min(min, price);
       }
       return maxProfit;
    }
}