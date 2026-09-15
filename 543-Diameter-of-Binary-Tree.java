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
    static class Info{
        int d;
        int h;
        public Info(int d,int h){
            this.d = d;
            this.h = h;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diam(root).d;
    }
    private Info diam(TreeNode root){
        if(root == null){
            return new Info(0,0);
        }
        Info l = diam(root.left);
        Info r = diam(root.right);

        int d = Math.max(Math.max(l.d,r.d),l.h+r.h);
        int h = Math.max(l.h,r.h)+1;
        return new Info(d,h);
    }
}