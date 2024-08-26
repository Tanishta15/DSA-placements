import java.util.*;;
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];//store the min no of coins needed to make each value from 0 to amount
        Arrays.fill(dp, amount + 1);// Initializes each element with (amount + 1), which represents an impossible case
        dp[0] = 0;//base condition
        for (int coin : coins) {//Loops through each coin in the coins
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                //(min no of coins needed to make i,how many coins would be needed if you include the current coin)
                //updates dp[i] to the lesser of its current value or the value derived from including the current coin    
            }
                }
                return dp[amount] > amount ? -1 : dp[amount];
                }
                }


//COIN CHANGE 2
/* 
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
    */