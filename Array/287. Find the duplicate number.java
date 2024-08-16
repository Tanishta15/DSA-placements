class Solution {
    public int findDuplicate(int[] nums) {
    int slow = nums[0];
    int fast = nums[0];
    do {
    slow = nums[slow];
    fast = nums[nums[fast]];
    } while (slow != fast);
    fast = nums[0];
    while (slow != fast) {
    slow = nums[slow];
    fast = nums[fast];
    }
    return slow;
    }
    }
    /*
    The slow pointer moves one step at a time (slow = nums[slow]).
The fast pointer moves two steps at a time (fast = nums[nums[fast]]).
The do-while loop continues until slow and fast meet. This meeting point is guaranteed due to the cycle caused by the duplicate number.
Once the intersection point is found, the fast pointer is reset to the start of the array (fast = nums[0]).
Both slow and fast pointers now move one step at a time (slow = nums[slow] and fast = nums[fast]).
The while loop continues until slow and fast meet again. This meeting point is the entrance to the cycle, which is the duplicate number.
First Loop (Finding the Intersection Point):

Iteration 1:
slow = nums[slow] = nums[1] = 3
fast = nums[nums[fast]] = nums[nums[1]] = nums[3] = 2
Iteration 2:
slow = nums[slow] = nums[3] = 2
fast = nums[nums[fast]] = nums[nums[2]] = nums[4] = 2
The do-while loop terminates as slow == fast (both are 2).
Second Loop (Finding the Entrance to the Cycle):

fast is reset to nums[0] = 1
Iteration 1:
slow = nums[slow] = nums[2] = 4
fast = nums[fast] = nums[1] = 3
Iteration 2:
slow = nums[slow] = nums[4] = 2
fast = nums[fast] = nums[3] = 2
The while loop terminates as slow == fast (both are 2).
Return the Duplicate Number:

return slow which is 2.
*/