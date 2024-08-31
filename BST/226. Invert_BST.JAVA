public class Invert_BST {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
            }
            //swapping using temp
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
            return root;
            }
            }
        }