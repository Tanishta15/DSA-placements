/*
 class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr = new ListNode(0);
        ptr.next = head;
        ListNode first = ptr;
        ListNode second = ptr;
        for (int i = 0; i <= n; i++) {
            first = first.next;
            }
            while (first != null) {
                first = first.next;
                second = second.next;
                }
                second.next = second.next.next;
                return ptr.next;
    }
}
 */