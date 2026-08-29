class Solution {
    public int maxProfit(int[] prices) {
        // find the buy from the left, and the sell from the right

        // [1 4 10 2]
        // [1 4 3 2]
        // [1 4 .. 2]

        // [3 4 100 2 10 1000]

        // [7 6 5 1 4 3]

        int minBuy = prices[0];
        int maxSell = prices[0];
        int maxDelta = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minBuy) {
                minBuy =  prices[i];

                // reset the buy-sell window
                maxSell = minBuy;
                
            } else if (prices[i] > maxSell) {
                maxSell = prices[i];
            }
            int delta = maxSell - minBuy;

            if (delta > maxDelta) {
                maxDelta = delta;
            }
        }

        return maxDelta;
    }
}
