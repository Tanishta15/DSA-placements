import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int data) {
        this.data = data;
    }
}
class Solution {
    public List<Integer> inorderTraversal(TreeNode root, int val) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
            }
            result.addAll(inorderTraversal(root.left,val));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right,val));
            return result;
        
    }
}