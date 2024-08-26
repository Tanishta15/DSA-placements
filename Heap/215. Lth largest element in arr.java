import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
    //Arrays.sort(nums);
    //return nums[nums.length - k];

    PriorityQueue<Integer>pq=new PriorityQueue<>();
    for(int i=0;i<k;i++){
    pq.add(nums[i]);
    }
    for(int i=k;i<nums.length;i++){
    if(pq.peek()<nums[i]){
    pq.remove();
    pq.add(nums[i]);
    }
    }
    return pq.peek();
    }
}
