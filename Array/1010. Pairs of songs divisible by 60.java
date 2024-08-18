class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int res = 0;
        for (int t : time) {
            int mod = t % 60;
            res += count[(60 - mod) % 60];
            count[mod]++;
            }
            return res;
            }
            }