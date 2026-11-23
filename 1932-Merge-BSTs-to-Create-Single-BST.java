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
    ArrayList<Integer> arr = new ArrayList<>();
    public TreeNode canMerge(List<TreeNode> trees) {
        if(trees.size() == 1) return trees.get(0);
        TreeNode parent = null;
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();

        for(int i=0;i<trees.size();i++){
            TreeNode temp = trees.get(i);
            if(temp.left!=null) children.add(temp.left.val);
            if(temp.right!=null) children.add(temp.right.val);
        }
        for(int i=0;i<trees.size();i++){
            TreeNode temp = trees.get(i);
            if(!children.contains(temp.val)){
                if(parent != null) return null;

                parent = temp;
            }
        }
        for(int i=0;i<trees.size();i++){
            TreeNode temp = trees.get(i);
            map.put(temp.val , temp);
        }
        helper(parent, map);
        if(map.size() != 1) return null;

        validate(parent);
        for(int i=1;i<arr.size();i++){
            if(arr.get(i) <= arr.get(i-1)) return null;
        }

        return parent;
    }
    private TreeNode helper(TreeNode root,HashMap<Integer, TreeNode> map){
        if(root == null) return null;

        if(root.left!=null && map.containsKey(root.left.val)){
            root.left = map.get(root.left.val);
            map.remove(root.left.val);
            helper(root.left, map);
        }
        if(root.right!=null && map.containsKey(root.right.val)){
            root.right = map.get(root.right.val);
            map.remove(root.right.val);
            helper(root.right, map);
        }

        return root;
    }
    private void validate(TreeNode root){
        if(root == null) return;

        validate(root.left);
        arr.add(root.val);
        validate(root.right);
    }
}