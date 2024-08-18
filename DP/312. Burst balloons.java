//Supposing the arr=[3,1,5,8] we are allowed to add padding to start and end as this does not cause any change
//arr=[1,3,1,5,8,1]
//if there are two balloons i.e [3,1] if we burst the 3 balloon last
//then the arr will be [starting 1,3,next of 1=5]
//else if balloon 1 last arr=[starting 1,1,5]

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];//adding +2 cuz of padding
        arr[0] = arr[n+1] = 1;   // Giving padding of 1 to the corner elements
        for(int i=1;i<=n;i++){
            arr[i] = nums[i-1];   //final padded array
        }
        
        int dp[][] = new int[n+2][n+2];//considering padding outside the arr
        for(int window = 1;window<=n;window++){  // window size,starts with size=1 i.e single elements and rises to entire arr
            for(int left = 1;left<=n-window+1;left++){ // left pointer to start
                int right = left+window-1;  // right pointer to end
                for(int i=left;i<=right;i++){   // iterate from left to right
                    dp[left][right] = Math.max(dp[left][right], (arr[left-1]*arr[i]*arr[right+1]) + dp[left][i-1] + dp[i+1][right]);
                //calc max values
                }
            }
        }
        return dp[1][n];
    }
}