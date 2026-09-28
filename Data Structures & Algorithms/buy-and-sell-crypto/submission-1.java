class Solution {
    // public int maxProfit(int[] prices) {
    //     int max = 0;
    //     int minBuy = prices[0];

    //     for (int sell : prices){
    //         max = Math.max(max, sell-minBuy);
    //         minBuy = Math.min(minBuy, sell);
    //     }
        
    //     return max;
    // }
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;

        int max = 0;

        while (right < prices.length){
            if (prices[left] < prices[right]){
                int profit = prices[right] - prices[left];
                max = Math.max(profit, max);
            } else {
                left = right;
            }
            right++;
        }
        return max;

    }
}
