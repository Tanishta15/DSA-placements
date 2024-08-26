//FIBBONACI SEQ

class Solution {
    public int climbStairs(int n) {
        if (n == 1) 
        return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            //if i=3 then after sub dp[2]+dp[1]=2+1 ways i.e 1+1+1,2+1,1+2
            dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
    }
}