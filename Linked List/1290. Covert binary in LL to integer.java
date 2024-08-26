class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
 class Solution {
    public int getDecimalValue(ListNode head) {
    int ans = 0;
        while(head != null){
            ans = ans*2 + head.val;//convert bin to decimal so multiply by 2
            head = head.next;
            }
            return ans;   
    }
}