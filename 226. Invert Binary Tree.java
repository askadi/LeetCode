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
    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
        helper(root);
    }
 
    return root;    
}
 
public void helper(TreeNode p){
 
    TreeNode temp = p.left;
    p.left = p.right;
    p.right = temp;
 
    if(p.left!=null)
        helper(p.left);
 
    if(p.right!=null)
        helper(p.right);
    }
}
