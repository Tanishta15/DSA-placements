/*
 class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
            }
            ListNode slow = head;
            ListNode fast = head;
            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
                }
            ListNode second = slow.next;
            ListNode prev = null;
            while(second != null){
                ListNode nextNode = second.next;
                second.next = prev;
                prev = second;
                second = nextNode;
                }
            ListNode first = head;
            while(prev != null){
                if(first.val != prev.val){
                    return false;
                    }
                first = first.next;
                prev = prev.next;
                }
                return true;
        
    }
}
 */