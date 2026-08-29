class Solution {
    public int maxProfit(int[] prices) {
        // find the buy from the left, and the sell from the right

        // [1 4 10 2]
        // [1 4 3 2]
        // [1 4 .. 2]

        // [3 4 100 2 10 1000]

        // [7 6 5 1 4 3]

        int minBuy = prices[0];
        int maxDelta = 0;

        for (int price : prices) {
            if (price < minBuy) {
                minBuy =  price;                
            } else if (price - minBuy > maxDelta) {
                maxDelta = price - minBuy;
            }
        }

        return maxDelta;
    }
}
