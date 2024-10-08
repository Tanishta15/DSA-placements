class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
 class Solution {
        public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
            }
            ListNode mid = getMiddle(head);
            ListNode midNext = mid.next;
            mid.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(midNext);
            return merge(left, right);
            }
            public ListNode getMiddle(ListNode head) {
            if (head == null) {
                return head;
                }
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                }
                return slow;
        }
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }
}