class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
 class Solution {
    public ListNode removeElements(ListNode head, int val) {
            if(head==null){
                return head;
            }
            head.next=removeElements(head.next,val);
            return head.val ==val ? head.next : head;
        }
    }