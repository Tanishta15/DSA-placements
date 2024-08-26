import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int left = 0;
            int right = n - 1;
            int top = 0;
            int bottom = m - 1;
            while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {//traverse top right
                res.add(matrix[top][i]);
                }
            for (int i = top + 1; i <= bottom; i++) {// traverse right till bottom
                res.add(matrix[i][right]);
                }
            if (left < right && top < bottom) {// traverse bottom till left
            for (int i = right - 1; i >= left; i--) {
                res.add(matrix[bottom][i]);
                }
            for (int i = bottom - 1; i > top; i--) {//go from bottom till up
                res.add(matrix[i][left]);
                }
                }
            left++;
            right--;
            top++;
            bottom--;
            }
            return res;
            }
            }