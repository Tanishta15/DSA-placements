import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
    /*
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i=0;i<matrix.length;i++)
        for(int j=0;j<matrix[0].length;j++)
            pq.add(matrix[i][j]);
    while(k-- > 1)
    pq.poll();
    return pq.poll();
    */

    int low = matrix[0][0];
    int high = matrix[matrix.length-1][matrix[0].length-1];
    while(low<high) {
        int mid = low+(high-low)/2;
        int count = count(matrix, mid);//counts no of elements in matrix <= mid

        if(count<k) {//fewer than k elements<=mid, so the k-th smallest must be greater
            low = mid+1;
        } else {//at least k elements less than or equal to mid, so the k-th smallest could be mid or smaller
            high = mid;
        }
    }
    return low;
}

    private int count(int[][] matrix, int D) {
        int count = 0;
         int j = matrix[0].length-1;//starts from last

         for(int i=0;i<matrix.length;i++) {
            while(j>=0 && matrix[i][j]>D) {//decreases j while the current element matrix[i][j] is greater than D
                j--;
            }
            count += j+1;//adds the count of elements in the current row that are less than or equal to D
         }
        return count;
    }
}
