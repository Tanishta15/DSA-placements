class Solution {
    public int search(int[] nums, int k) {
        int low =0; int high = nums.length-1;
        while (low<=high){
            int mid = low+ (high-low)/2;
            if(nums[mid]==k) //mid remains same after rotation
            return mid;
            else if(nums[low]<=nums[mid]){//search between low and mid
                if(k>=nums[low]&&k<=nums[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{//search between mid and high
                if(k>=nums[mid] && k<=nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }

        }
        return -1;
    }
}