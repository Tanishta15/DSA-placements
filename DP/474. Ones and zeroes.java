class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int ones = 0, zeros = 0;
            for (char c : str.toCharArray()) {
                if (c == '1') 
                ones++;
                else 
                zeros++;
                }
        // loop runs till condition is not satisfied
        for (int i = m; i >= zeros; i--) {
            for (int j = n; j >= ones; j--) {//decrease number needed as it is found
                dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j- ones] + 1);
                }
                }
                }
                return dp[m][n];
    }
}