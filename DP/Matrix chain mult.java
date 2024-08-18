class Solution {
    public int matrixMultiplication(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];//matrix nxn
        for (int len=2;len<n;len++){//traversing diagnolly
            //starting from 2 as values before 2 =0
            for(int row=0, col=len;row<n-len;row++,col++){//helping in making the diagnol
                dp[row][col]=Integer.MAX_VALUE;//cuz we want min val so initialise with max
                for(int k=row+1;k<col;k++){//k is the middle element of two pairs of arr
                //therefore iterates from row+1 to col-1
                dp[row][col]=Math.min(dp[row][col], dp[row][k]+dp[k][col]+nums[row]*nums[k]*nums[col]);
                //(cur val,leftdp[ans]+rightdp[ans]+combined ans)
            }
                col++;
                }
                }
                return dp[0][n-1];
            }
        }