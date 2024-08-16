class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        int sum = 0;
        int res = 0;
        count[0] = 1;
        for (int num : nums) {
            sum += num;
            int mod = (sum % k + k) % k;
            res += count[mod];
            count[mod]++;
            }
            return res;
    }
}