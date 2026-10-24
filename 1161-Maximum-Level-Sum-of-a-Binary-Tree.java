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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int res = 1;
        int level = 1;
        int sum = root.val;

        while(!q.isEmpty()){
            int levelSum = 0;   
            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                levelSum += node.val;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }

            if(levelSum > sum){
                sum = levelSum;
                res = level;
            }
            level++;
        }
        return res;
    }
}