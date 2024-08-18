import java.util.Arrays;

class Solution {
    public int minCost(int n, int[] cuts) {
        int[] m = new int[cuts.length + 2];//adding 1 on each side of the cut
        for(int i = 0; i < cuts.length; i++){
            m[i + 1] = cuts[i];
        }
        m[m.length - 1] = n;//new array after end is cut
        Arrays.sort(m);
        int[][] dp = new int[m.length][m.length];
        for(int i = 0; i < dp.length; i++){
            for(int j = i - 1; j >= 0; j--){
                for(int k = i - 1; k > j; k--){
                    int ans = Math.min(dp[j][i] == 0 ? Integer.MAX_VALUE : dp[j][i], m[i] - m[j] + dp[j][k] + dp[k][i]);
                    dp[j][i] = ans;

                }
            }
        }
        return dp[0][m.length - 1];   
    }
}

//DOING IT FOR ROD => SIMILAR APPROACH

/* 
class Solution {
    public int cutRod(int price[], int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
        for (int j = 0; j < i; j++) {
            dp[i] = Math.min(dp[i], dp[j] + price[i - 1 -j]);
        }
        }
        return dp[n];
        }
        }
    */