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
    private int preIdx;
    private Map<Integer,Integer> map ;
    
    private TreeNode build(int[] preorder, int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
        }
        int rootValue = preorder[preIdx++];
        TreeNode root = new TreeNode(rootValue);

        int rootIdx = map.get(rootValue);
        root.left = build(preorder, inStart, rootIdx-1);
        root.right = build(preorder, rootIdx + 1, inEnd);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0;
        map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length-1);
    }
}