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
    private void getInorder(ArrayList<Integer> inorder, TreeNode root){
        if(root == null){
            return;
        }
        getInorder(inorder, root.left);
        inorder.add(root.val);
        getInorder(inorder, root.right);
    }
    private TreeNode create(ArrayList<Integer> inorder,int st,int end){
        if(st > end){
            return null;
        }
        int mid = st+(end-st)/2;
        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = create(inorder, st, mid-1);
        root.right = create(inorder, mid+1, end);

        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        // inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(inorder, root);
        
        root = create(inorder, 0, inorder.size()-1);

        return root;
    }
}