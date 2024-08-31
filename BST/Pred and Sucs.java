class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        Node current = root;
        
        while(current != null) {
            if(current.data <= key){//if greater move right
                current = current.right;
            } else {//else update current and move left
                suc[0] = current;
                current = current.left;
            }
        }
        
       Node current1 = root;
        while(current1 != null) {//if lesser move left
            if(current1.data>=key) {
                current1 = current1.left;
            } else {//else update current and move right
                pre[0] = current1;
                current1 = current1.right;
            }
        }
        }
}