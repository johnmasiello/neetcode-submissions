class Solution {
    public int maxProfit(int[] prices) {
        // find the buy from the left, and the sell from the right

        // [1 4 10 2]
        // [1 4 3 2]
        // [1 4 .. 2]

        // [7 6 5 1 4 3]

        int minBuy = prices[0];
        int maxSell = prices[prices.length - 1];

        int[][] minMax = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minBuy) {
                minBuy =  prices[i];
            }
            if (prices[prices.length - 1 - i] > maxSell) {
                maxSell = prices[prices.length - 1 - i];
            }
            minMax[i][0] = minBuy;
            minMax[prices.length - 1 - i][1] = maxSell;
        }

        int delta = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minMax[i][1] - minMax[i][0] > delta) {
                delta = minMax[i][1] - minMax[i][0];
            }
        }

        return delta > 0 ? delta : 0;
    }
}
