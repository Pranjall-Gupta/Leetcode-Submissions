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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        check(root,targetSum,new ArrayList<>(),0,ans);
        return ans;        
    }
    private void check(TreeNode root,int target, List<Integer> curr,int sum,List<List<Integer>> ans){
        if(root==null) return;
        sum=sum+root.val;
        curr.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==target)
                ans.add(new ArrayList<>(curr));
        }
        else{
            check(root.left,target,curr,sum,ans);
            check(root.right,target,curr,sum,ans);
        }
        curr.remove(curr.size()-1);//last ele -> backytrack
        
    }
}