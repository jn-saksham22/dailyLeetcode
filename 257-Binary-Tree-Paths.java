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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        paths(root,ans,new StringBuilder());
        return ans;
    }
    private void paths(TreeNode root,List<String> ans,StringBuilder s){
        if(root == null){
            return;
        }
        int len = s.length();
        s.append(root.val);

        if(root.left == null && root.right == null){
            ans.add(s.toString());
        }
        else{
            s.append("->");
          paths(root.left,ans,s);
          paths(root.right,ans,s);
        }
        s.setLength(len);
    }
}