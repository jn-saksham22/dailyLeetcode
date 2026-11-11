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
    public TreeNode bstFromPreorder(int[] preorder) {
      return  build(preorder, 0, preorder.length-1);
    }
    private TreeNode build(int preorder[] ,int start, int end){
        if(start > end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int left = start+1;
        int right = end+1;

        while(left < right){
            int mid = left+(right-left)/2;

            if(preorder[mid] > root.val) right = mid;
            else left = mid+1;
        }
        int idx = left;

        root.left = build(preorder, start+1, idx-1);
        root.right = build(preorder, idx, end);

        return root;
    }
}