import java.util.ArrayList;
import java.util.List;
// If i comes across 4 it means array length is 4 because of the condition
// Make [i] as vis. If vis>1 means duplicate present
// Marking -ve means vis,add it to the list(take mod)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
    List<Integer> list = new ArrayList<>();
    for(int i=0;i<nums.length;i++){
    int index = Math.abs(nums[i])-1;
    if(nums[index]<0){
    list.add(index+1);
    }
    else{
    nums[index] = -nums[index];
    }
    }
    return list; 
    }
}