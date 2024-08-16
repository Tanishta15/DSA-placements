class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
        sum = sum + cardPoints[i];
        }
        int max = sum;
        for (int i = k - 1; i >= 0; i--) {
            sum = sum - cardPoints[i];
            sum = sum + cardPoints[n - k + i];
            max = Math.max(max, sum);
            }
            return max;
            }
            }