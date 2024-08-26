class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ptr = new ListNode(0);
        ptr.next = head;
        ListNode current = ptr;
        while(current.next != null && current.next.next != null){//next two should not be null
            if(current.next.val == current.next.next.val){//if next both are duplicate
                int duplicate = current.next.val;//declare the next one duplicate
            while(current.next != null && current.next.val == duplicate){//then when iterating if we detect val just skip it
                current.next = current.next.next;//skipping
                }
                }
                }
            return ptr.next;      
    }
}