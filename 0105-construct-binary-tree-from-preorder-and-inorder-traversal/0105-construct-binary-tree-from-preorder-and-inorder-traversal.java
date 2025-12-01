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
    int preIdx=0;
    HashMap<Integer, Integer> map=new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1);
    }
    private TreeNode build(int[] preorder, int Start,int End){
        if(Start>End) return null;
        int preVal=preorder[preIdx++];
        TreeNode root=new TreeNode(preVal);

        int mid=map.get(preVal);
        root.left=build(preorder,Start,mid-1);
        root.right=build(preorder,mid+1,End);

        return root;
    }
}