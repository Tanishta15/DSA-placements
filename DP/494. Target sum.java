class Solution {
    int[] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;// base cond
        for(int n : nums) {
            total += n;//sum of all elements in nums
        }
        target = Math.abs(target);
        // problem is symmetric around zero, so taking the absolute value of the target simplifies the problem
        if((target + total) % 2 == 1) {
        //If the sum of target and total is odd, it is impossible to split the numbers into two subsets
            return 0;
        }
        int s1 = (target + total) / 2;
        //splitting nums into two subsets where one subset sums to s1 and the other to total - s1
        dp = new int [s1 + 1];//store the number of ways to achieve sum up to s1
        dp[0] = 1;//one way to achieve a sum 0 by selecting no elements
        find(nums, 0, s1);// recursive helper function that fills the DP array
        return dp[s1];
    }

    private void find(int[] nums, int idx, int target) {
        if(idx == nums.length) {
            return;
        }
        for(int n = target; n >= nums[idx]; n--) {//backtrack
            dp[n] = dp[n] + dp[n - nums[idx]];//adding the number of ways to form the sum n - nums[idx]
        }
        find(nums, idx + 1, target);//recursive call
    }
}