class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
 class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
     ListNode ptr = new ListNode(0);
        ListNode cur = ptr;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
                }
            else{
                cur.next = list2;
                list2 = list2.next;
                }
                cur = cur.next;
                }
            if(list1 != null){
                cur.next = list1;
                }
            else if(list2 != null){
                cur.next = list2;
                }
            return ptr.next;     
    }
}
