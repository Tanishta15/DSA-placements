class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
 class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
            }
            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){//at one point they meet
                    return true;
                    }
                    }
                    return false;
    }
}