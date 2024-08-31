import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
        }
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
            }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
        for (TreeNode l : left) {
            for (TreeNode r : right) {
                TreeNode root = new TreeNode(i);
                root.left = l;
                root.right = r;
                res.add(root);
                }
                }
                }
                return res;
    }
}