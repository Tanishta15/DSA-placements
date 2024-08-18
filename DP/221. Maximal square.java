class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length ==0) {
            return 0;
            }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSide = 0;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
        if (matrix[i][j] == '1') {
        if (i == 0 || j == 0) {//if cell at edge
            dp[i][j] = matrix[i][j] - '0';
            } 
        else {//min of all 3 other sides
            dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
            }
            maxSide = Math.max(maxSide, dp[i][j]);
            }
            }
            }
        return maxSide * maxSide;       
        }
    }