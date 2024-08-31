
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)//if no tree then true
        return true;
        if(root == null || subRoot == null)//if any one exists then false
        return false;
        //if left || right not identical then false
        return isSafe(root , subRoot) || isSubtree(root.left , subRoot)||isSubtree(root.right ,subRoot);
    }
    private boolean isSafe(TreeNode root ,TreeNode subRoot){
        if(root == null && subRoot == null)
        return true;
        if(root == null || subRoot == null)
        return false;
        if(root.val == subRoot.val){
            return isSafe(root.left , subRoot.left)&&isSubtree(root.right ,subRoot.right);
        }
        return false;
    }
}