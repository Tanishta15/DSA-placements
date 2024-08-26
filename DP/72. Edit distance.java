//Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
//Insert a character, Delete a character, Replace a character

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
        for (int j = 0; j <= n; j++) {
        if (i == 0) {//base case
            dp[i][j] = j;
            } 
        else if (j == 0) {//base case
            dp[i][j] = i;
            } 
        else if (word1.charAt(i - 1) == word2.charAt(j -1)) {
            //if last char match remove from behind
            dp[i][j] = dp[i - 1][j - 1];
            } 
        else {
            //remove one not other or both
            dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j -1]);
                }
                }
                }
            return dp[m][n];
    }
}

//ITERATING USING PREVIOUS VALUES
/* 
class Solution {
    public int editDistance(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) 
        dp[i][0] = i;
        for (int j = 0; j <= n; j++)
        dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1];
            } 
        else {
            dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j -1]);
            }
            }
            }
            return dp[m][n];
            }
            }
*/