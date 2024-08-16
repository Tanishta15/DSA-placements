/*
class Solution<ListNode> {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            }
            return slow;
            }
            }
            */