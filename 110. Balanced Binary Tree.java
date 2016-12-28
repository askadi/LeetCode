/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        
        if(getHeight(root) == -1)
            return false;
        return true;
    }
    public int getHeight(TreeNode root){
        if(root == null)
            return 0;
        int leftHeight = getHeight(root.left);
        if(leftHeight == -1)
            return -1;
        int rightHeight = getHeight(root.right);
        if(rightHeight == -1)
            return -1;
        int heightDiff = leftHeight - rightHeight;
        if(Math.abs(heightDiff) > 1)
            return -1;
        return Math.max(leftHeight,rightHeight) + 1;
    }
}
