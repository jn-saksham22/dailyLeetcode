/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode helper(TreeNode root){
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;

        TreeNode rightChild = root.right;
        TreeNode leftChild = root.left;

        TreeNode leftMostRight = rightChild;

        while(leftMostRight.left != null){
            leftMostRight = leftMostRight.left;
        }

        leftMostRight.left = leftChild;

        return rightChild;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val == key){
            return helper(root);
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else 
            root.right =  deleteNode(root.right, key);

        return root;
    }
}