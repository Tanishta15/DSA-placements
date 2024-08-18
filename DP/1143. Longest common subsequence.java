
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //if last char matches then further break
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                dp[i][j] = dp[i - 1][j - 1] +1;
                else
                //discard last char of one string or last of other
                dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);//max of above two cells
                }
                }
                return dp[m][n];
    }
}

/* 
// RECURSIVE WITH CONDITIONS
class Solution {
    static int lcs(int m,int n, String text1,String text2){
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;//initially all cells have -1 except 0th row and col
            }
        }
        return lcsUtil(m,n,text1,text2,dp);
    }

    private static int lcsUtil(int m, int n, String text1, String text2, int dp[][]) {
        if(m == 0 || n == 0)//base case
        return 0;
        if(dp[m][n]!=-1){//only go to places which have a value
            return dp[m][n];
        }
        if(text1.charAt(m-1) == text2.charAt(n-1))
        //if last char matches then further break
        return dp[m][n] = 1 + lcsUtil(m-1,n-1,text1,text2,dp);
        else
        //discard last char of one string or last of other
        return dp[m][n] = Math.max(lcsUtil(m-1,n,text1,text2,dp),lcsUtil(m,n-1,text1,text2,dp));
    }
    }

// RECURSIVE CALL = O(2^n)

class Solution {
    static int lcs(int m,int n, String text1,String text2){
        return lcsUtil(m,n,text1,text2);
    }

    private static int lcsUtil(int m, int n, String text1, String text2) {
        if(m == 0 || n == 0)//base case
        return 0;
        if(text1.charAt(m-1) == text2.charAt(n-1))
        //if last char matches then further break
        return 1 + lcsUtil(m-1,n-1,text1,text2);//call again after breaking
        else
        //discard last char of one string or last of other
        return Math.max(lcsUtil(m-1,n,text1,text2),lcsUtil(m,n-1,text1,text2));
    }
    }
*/