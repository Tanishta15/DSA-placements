class Solution {
    public void moveZeroes(int[] nums) {
    int i = 0;
    int j = 0;
    while (i < nums.length) {
    if (nums[i] != 0) {
    nums[j] = nums[i];
    j++;//if zero then move in j
    }
    i++;//else move in i
    }
    for (int k = j; k < nums.length; k++) {
        nums[k] = 0;
        }
        }
        }