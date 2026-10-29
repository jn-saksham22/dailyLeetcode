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
    private void buildParentTrack(TreeNode root,Map<TreeNode, TreeNode> map){
        Queue<TreeNode> q = new LinkedList<>();
        map.put(root, null);
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                map.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right!=null){
                map.put(node.right,node);
                q.offer(node.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Map<TreeNode, TreeNode> map = new HashMap<>();
        buildParentTrack(root, map);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        Set<TreeNode> visit = new HashSet<>();
        visit.add(target);

        int dist = 0;
        while(!q.isEmpty()){
            if(dist == k) break;

            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();

                if(node.left!=null && !visit.contains(node.left)){
                    visit.add(node.left);
                    q.offer(node.left);
                }
                if(node.right!=null && !visit.contains(node.right)){
                    visit.add(node.right);
                    q.offer(node.right);
                }
                TreeNode parent = map.get(node);
                if(parent != null && !visit.contains(parent)){
                    visit.add(parent);
                    q.offer(parent);
                }

            }
            dist ++ ;
        }
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}