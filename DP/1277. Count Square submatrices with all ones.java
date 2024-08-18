class Solution {
    public int solve(int [][]dp,int row,int col){
        //if even one element is zero  in converts it to zero
        return Math.min(dp[row-1][col-1],Math.min(dp[row][col-1],dp[row-1][col]));
    }
    public int countSquares(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int [][]dp=new int[n][m];
        for(int i=0;i<n;i++){//traversing rows
            dp[i][0]=matrix[i][0];//individual elements
        }
        for(int i=0;i<m;i++){//traversing cols
            dp[0][i]=matrix[0][i];//individual elements
        }
        for(int i=1;i<n;i++){//now we can make squares
            for(int j=1;j<m;j++){
                if(matrix[i][j]==1){//if all 1's
                    dp[i][j]=1+solve(dp,i,j);
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans+=dp[i][j];//increment ans everytime condition is satisfied
            }
        }
        return ans;
    }
}