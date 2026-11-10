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
    private int cnt = 0;
    private int ans = -1;

    private void dfs(TreeNode root, int k){
         if(root == null) return;

         dfs(root.left, k);

         cnt++;

         if(cnt == k){
            ans = root.val;
            return;
         }
         if(cnt < k) dfs(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
    
       dfs(root, k);
       return ans;
    }
}