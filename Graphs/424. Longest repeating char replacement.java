class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int n = s.length();
        for (char c = 'A'; c <= 'Z'; c++) {
            int i = 0, j = 0, replaced = 0;
            while (j < n) {
            if (s.charAt(j) == c) {//j is incremented to expand the window
                j++;
            } 
            //char at j not c and we have not yet replaced k chars in this window, increment j to include this character in the window and increase the replaced count by 1
            else if (replaced < k) {
                j++;
                replaced++;
            } 
            //char at i is c, increment i to shrink the window from the left without affecting the replaced
            else if (s.charAt(i) == c) {
                i++;
            } 
            //char at i is not c, increment i to shrink the window from the left and decrement the replaced count
            else {
                i++;
                replaced--;
            }
            ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }
}