class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}
class Solution {
    Node compute(Node head) {
        // Medium-Hard question
        // 1. 
        // 2.Use two pointers, curr and next, 
        // 2.1 
        // 2.2 repeat process until max is reached
        // 3. reverse the list again fro, max;
        
        Node prev = null;
        Node curr = head;
        Node next = head.next;
        while(curr!=null){//find the max value while reversing towards end.
            // traverse next to find any value > curr
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) next = next.next;
        }
        
        curr = prev;
        next = prev.next;
        Node temp = prev;  //points to reversed head
        while(next != null){
            if(curr.data <= next.data){//if found, connect curr to next and move curr to next;
                curr.next = next;
                curr = curr.next;
            }
            next = next.next;
        }
        curr.next = null;
        // reversing list again for max
        prev = null;
        curr = temp;
        next = curr.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) next = next.next;
        }
        
        head = prev;
        return head;
    }
}