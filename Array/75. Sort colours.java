class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i = 0; i < nums.length; i++){//counts how many times each of the numbers (0, 1, 2) appear
            count[nums[i]]++; // count++ for 0,1,2 individually
            }
            int i = 0;
            for(int j = 0; j < 3; j++){
                while(count[j]-- > 0){//When j = 0, fills the nums array with 0s till decremented to 0
                    nums[i++] = j;
                    }
                    }
                    }
                }