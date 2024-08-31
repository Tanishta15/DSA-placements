class Solution {
    public ListNode partition(ListNode head, int x) {
        //dummy nodes are created and initialized to a new ListNode(0)
        ListNode prev = new ListNode(0);
        ListNode prevHead = prev;//prev will be used to build a new list of nodes with values< x
        ListNode ptr = new ListNode(0);
        ListNode ptrHead = ptr;//ptr will be used to build a new list of nodes with values >=x
        while (head != null) {
            if (head.val < x) {//If the value of current node<x, it is added to the prev list
                prev.next = head;//links the current node to the prev list
                prev = prev.next;//moves the prev pointer forward
                } 
            else {
                ptr.next = head;// links the current node to the ptr list
                ptr = ptr.next;//moves the ptr pointer forward
                }
                head = head.next;//move ahead
                }//all nodes have been partitioned into two lists
                prev.next = ptrHead.next;//connects the end of the prev list to the beginning of the ptr list
                ptr.next = null;//last node of the combined list does not point to any further node
                return prevHead.next;
                }
                }
