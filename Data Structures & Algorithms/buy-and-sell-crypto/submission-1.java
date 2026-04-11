class Solution {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE, buy = Integer.MAX_VALUE;
        for (int price : prices){
            buy = Math.min(price, buy);
            max = Math.max(max, price - buy);
        }

        return max;
    }
}
