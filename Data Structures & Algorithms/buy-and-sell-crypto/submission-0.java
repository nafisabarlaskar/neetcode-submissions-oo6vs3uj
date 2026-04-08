class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], maxProfit = 0;
        for (int price : prices){
            buy = Math.min(price, buy);
            maxProfit = Math.max(maxProfit, price - buy);
        }

        return maxProfit;
    }
}
