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
class BSTIterator {
    private Stack<TreeNode> st;
    
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }
    public BSTIterator(TreeNode root) {
         st = new Stack<>();
        pushAllLeft(root);
    }
    
    public int next() {
        TreeNode topNode = st.pop();
        
        if (topNode.right != null) {
            pushAllLeft(topNode.right);
        }
        
        return topNode.val;
    }
    
    public boolean hasNext() {
                return !st.isEmpty();

    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */