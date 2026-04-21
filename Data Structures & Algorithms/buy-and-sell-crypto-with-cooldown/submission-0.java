class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }

        int buy0 = -prices[0], buy1 = buy0, sell0 = 0, sell1 = 0, sell2 = 0;
        for (int price : prices){
            buy0 = Math.max(buy1, sell2 - price);
            sell0 = Math.max(sell1, buy1 + price);
            sell2 = sell1;
            sell1 = sell0;
            buy1 = buy0;
        }

        return sell0;
    }
}
