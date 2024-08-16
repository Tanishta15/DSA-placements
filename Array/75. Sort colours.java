class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i = 0; i < nums.length; i++){
            count[nums[i]]++;
            }
            int i = 0;
            for(int j = 0; j < 3; j++){
                while(count[j]-- > 0){
                    nums[i++] = j;
                    }
                    }
                    }
                }