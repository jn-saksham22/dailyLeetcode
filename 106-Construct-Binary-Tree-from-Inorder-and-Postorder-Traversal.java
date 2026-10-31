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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode build(int[] inorder,int inStart, int inEnd, int[] postorder,int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd) return null;

        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        int rootIdx = 0;
        for(int i=inStart; i<=inEnd; i++){
            if(inorder[i] == rootValue) {
                rootIdx = i;
                break;
            }
        }
        int leftsize = rootIdx - inStart;
        int rightsize = inEnd - rootIdx;
        root.left = build(inorder, inStart, rootIdx-1, postorder, postStart, postStart + leftsize-1);
        root.right = build(inorder, rootIdx+1, inEnd, postorder, postEnd-rightsize, postEnd-1);

        return root;
    }
}