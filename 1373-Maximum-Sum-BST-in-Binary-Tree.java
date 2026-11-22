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
    class Info{
        Boolean isBST;
        int sum;
        int min;
        int max;

        public Info(Boolean isBST,int sum,int min,int max){
            this.isBST = isBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }
    static int maxSum = 0;

    private Info findBSTSum(TreeNode root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = findBSTSum(root.left);
        Info right = findBSTSum(root.right);
        int sum = root.val + left.sum + right.sum;
        int min = Math.min(root.val,Math.min(left.min,right.min));
        int max = Math.max(root.val,Math.max(left.max,right.max));

        if(root.val <= left.max || root.val >= right.min){
            return new Info(false, sum, min, max);
        }
        if(left.isBST && right.isBST && root.val > left.max && root.val < right.min){
            maxSum = Math.max(maxSum, sum);
            return new Info(true, sum, min, max);
        }

        return new Info(false, sum, min, max);
    }
    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        Info info = findBSTSum(root);
        return maxSum;
    }
}