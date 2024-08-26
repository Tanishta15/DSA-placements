class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        int sum = 0;
        int res = 0;
        count[0] = 1;
        for (int num : nums) {
            sum += num;
            int mod = (sum % k + k) % k;//calculates remainder for cumulative sum. This helps in tracking the subarrays whose sums are divisible by k
            //adding k to the result, we make sure the remainder is non-negative
            //final % brings the value back within the range of 0 to k-1
            res += count[mod];// frequency of each possible remainder value
            count[mod]++;// counting how many subarrays have cumulative sum divisible by k
            }
            return res;
    }
}