class Solution {
    public static long[] productExceptSelf(int nums[]) {
        int n = nums.length;
        long[] ans = new long[n];
   for (int i = 0; i < n; i++) {
            ans[i] = 1;
        }

        long leftProduct = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = leftProduct;
            leftProduct *= nums[i];
        }
        long rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return ans;
    }
}         