class Solution {
    public int maxProfit(int[] prices) {
         int profit = 0;
for (int i = 0; i < prices.length - 1; i++) {
    for (int j = i+1; j < prices.length && j>i; j++) {
        int currentProfit = prices[j] - prices[i];
        profit = Math.max(profit, currentProfit);
    }
}
return profit;

    }
}
/*
// PART 2
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
                }
                }
                return maxProfit;
        
    }
}

//WITH COOLDOWN DAY
class Solution {
    public int maxProfit(int[] prices) {
    int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
    for (int price : prices) {
        prev_buy = buy;
        buy = Math.max(prev_sell - price, prev_buy);
        prev_sell = sell;
        sell = Math.max(prev_buy + price, prev_sell);
    }
    return sell;
}
}

// WITH TRANSACTION FEE
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int newBuy = Math.max(buy, sell - prices[i]);
            int newSell = Math.max(sell, buy + prices[i] - fee);
            buy = newBuy;
            sell = newSell;
            }
            return sell;
        
    }
}
    */