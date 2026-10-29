/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void collectDown(TreeNode root, int dist, List<Integer> ans){
        if(root == null || dist < 0) return;
        if(dist == 0){
            ans.add(root.val);
            return;
        }
        collectDown(root.left, dist-1, ans);
        collectDown(root.right, dist-1, ans);
    }
    private int findTarget(TreeNode node, TreeNode target, int k,List<Integer> ans){
        if(node == null) return -1;

        if(node == target){
            collectDown(node, k , ans);
            return 0;
        }
        int left = findTarget(node.left,target, k, ans);
        if(left != -1){
            int currDist = left + 1;
            if(currDist == k){
                ans.add(node.val);
            }else{
                collectDown(node.right,k-currDist-1 ,ans);
            }
            return currDist;
        }
        int right = findTarget(node.right, target, k,ans);
        if(right != -1){
            int currDist = right + 1;
            if(currDist == k){
                ans.add(node.val);
            }else{
                collectDown(node.left, k-currDist-1,ans);
            }
            return currDist;
        }
        return -1;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        findTarget(root, target, k, ans);

        return ans;
    }
}