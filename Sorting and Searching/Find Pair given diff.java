import java.util.Arrays;

class Solution {
    public int findPair(int n, int x, int[] arr) {
    Arrays.sort(arr);
    int i = 0;
    int j = 1;

    while (i < n && j < n) {
        if (i != j && arr[j] - arr[i] == x) {
            return 1;
        } else if (arr[j] - arr[i] < x) {
            j++;
        } else {
            i++;
        }
    }

    return -1;
    }
}