import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //handling cases where the subarray starts from the beginning and directly sums up to k
        map.put(0, 1);//cumulative sum of 0 with a count of 1
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        //code is looking for a cumulative sum of k earlier in the array. 
        //If such a sum exists, it means the subarray from the point where sum = k to the current index has a sum of 5
        if (map.containsKey(sum - k)) {// sum-k is element and if its present count++
            count += map.get(sum - k);
            }
            //returns the current frequency of sum if it exists in the map or 0 if it does not
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
    }
}