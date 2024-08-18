//KADANE ALGO - 1D AND 2D => O(n)
/* 
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
            }
            return maxSum;
            }
            }
*/

import java.util.Arrays;

class Solution {
    public int MaximalRectangle(int C, int R, int[][] matrix) {
        int sum[] = new int[R];//row 1d arr
        int maxSum = Integer.MIN_VALUE;//taking smallest value as can contain -ve
        for(int cStart=0;cStart<C;cStart++){//starting col
            Arrays.fill(sum, 0);//fill sum arr with 0
        for(int cEnd=cStart;cEnd<C;cEnd++){//start from cStart and end at last col needed
            for(int r=0;r<R;r++){
                sum[r] += matrix[r][cEnd];//adding cur col to sum arr
            }
            int curMaxSum=kadane(sum);
            maxSum=Math.max(maxSum,curMaxSum);
        }
    }
        return maxSum;
}
int kadane(int[] arr){
    int size=arr.length;
    int maxfar=Integer.MIN_VALUE, maxend=0;
    for(int i=0;i<size;i++){
        maxend=Math.max(arr[i],maxend+arr[i]);
        if (maxfar<maxend) {
            maxfar=maxend;
            }
            if (maxend<0) {
                maxend=0;
            }
            }
            return maxfar;
        }
    }
