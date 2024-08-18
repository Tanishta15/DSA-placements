//The time complexity=O(n) and the space complexity is O(n).
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //res[i] stores the number of 1 bits
            //i / 2 shifts the binary of i one place to the right, which is equi to removing (LSB)
            //res[i / 2] gives the number of 1,(i % 2) adds 1 if i is odd, or 0 if i is even
            res[i] = res[i / 2] + (i % 2);
            }
            return res;
            }
            }