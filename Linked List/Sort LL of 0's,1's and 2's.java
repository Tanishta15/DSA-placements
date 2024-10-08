class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
class GFG {
    public static void sortList(ListNode head) {
      
        int[] cnt = { 0, 0, 0 };
        ListNode ptr = head;

        // Traverse and count total number of '0', '1' and '2'
        // cnt[0] will store total number of '0's
        // cnt[1] will store total number of '1's
        // cnt[2] will store total number of '2's
        while (ptr != null) {
            cnt[ptr.val] += 1;
            ptr = ptr.next;
        }

        int idx = 0;
        ptr = head;
        
        // Fill first cnt[0] nodes with value 0
        // Fill next cnt[1] nodes with value 1
        // Fill remaining cnt[2] nodes with value 2
        while (ptr != null) {
            if (cnt[idx] == 0)
                idx += 1;
            else {
                ptr.val = idx;
                cnt[idx] -= 1;
                ptr = ptr.next;
            }
        }
    }
}