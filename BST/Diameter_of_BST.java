public class Diameter_of_BST {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[]{0};
        dfs(root, res);
        return res[0];
        }

public int dfs(TreeNode root, int[] res){
    if(root == null){
        return 0;
        }
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        res[0] = Math.max(res[0], left + right);
        return Math.max(left, right) + 1;
        }
        }
    }