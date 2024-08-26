class Solution {
    public int maxProfit(int[] prices) {
         int profit = 0;
for (int i = 0; i < prices.length - 1; i++) {
    for (int j = i+1; j < prices.length && j>i; j++) {
        int currentProfit = prices[j] - prices[i];
        profit = Math.max(profit, currentProfit);// update profit
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
        int buy = -prices[0];// if we buy the stock on the first day, our profit is negative
        int sell = 0;// starts with 0 because if we haven't made any transactions, our profit is 0
        for (int i = 1; i < prices.length; i++) {
            int newBuy = Math.max(buy, sell - prices[i]);//profit if we decide to buy on day i
            int newSell = Math.max(sell, buy + prices[i] - fee);
            //maximum profit between holding the stock we already have or buying a new one on day i
            buy = newBuy;
            sell = newSell;
            }
            return sell;
    }
}
    */