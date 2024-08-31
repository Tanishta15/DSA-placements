import java.util.ArrayList;

class TreeNode {
    int val = 0;
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}
class BSTIterator {
    ArrayList<TreeNode> arr = new ArrayList<>();
    int k =0;
    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    
    public void inorder(TreeNode root){
        if(root==null)
               return;
        inorder(root.left);
        arr.add(root);
        inorder(root.right);
    }
    
    public int next() {
        //iterate
         return arr.get(k++).val;
    }
    
    public boolean hasNext() {
        //till arr size
        return k<arr.size();
    }
}