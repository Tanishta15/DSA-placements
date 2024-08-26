class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
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
            ListNode prev = null;//used to reverse the second half of the list
            while(second != null){//iterates over the second half of the linked list to reverse it
                ListNode nextNode = second.next;//Save the next node (to continue traversal after reversal)
                //REVERSAL OF LL(SECOND HALF THO)
                second.next = prev;//Reverse the current node's pointer to point to the previous node
                prev = second;//Move the prev pointer forward to the current node
                second = nextNode;//Move the second pointer forward to the next node
                }
            ListNode first = head;//start of the first half
            while(prev != null){//compares the nodes of the first half and the reversed second half
                if(first.val != prev.val){//If the values of the nodes are not equal, it means the list is not a palindrome
                    return false;
                    }
                first = first.next;//Move to the next node in the first half
                prev = prev.next;//Move to the next node in the reversed second half
                }
                return true;
        
    }
}