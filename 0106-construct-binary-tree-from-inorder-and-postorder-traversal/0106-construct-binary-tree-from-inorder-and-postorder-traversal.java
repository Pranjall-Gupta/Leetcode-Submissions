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
    int postIdx=0;
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(postorder,0,inorder.length-1);
    }
    private TreeNode build(int[] postorder,int Start,int End){
        if(Start>End) return null;
        
        int postVal=postorder[postIdx--];
        TreeNode root=new TreeNode(postVal);

        int mid=map.get(postVal);

        root.right=build(postorder,mid+1,End);
        root.left=build(postorder,Start,mid-1);

        return root;
    }
}