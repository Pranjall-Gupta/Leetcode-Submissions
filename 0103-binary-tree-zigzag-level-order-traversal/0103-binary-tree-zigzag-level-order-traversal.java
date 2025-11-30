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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int count=0;
        while(!q.isEmpty()){
            List<Integer> level=new ArrayList<>();
            int n=q.size();
            count++;
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                level.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if(count%2==0) Collections.reverse(level);
            list.add(level);
        }
        return list;
    }
}