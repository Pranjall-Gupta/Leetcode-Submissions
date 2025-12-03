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
    int pre[],post[];
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.pre = preorder;
        this.post = postorder;
        for(int i=0;i<postorder.length;i++)
            map.put(postorder[i],i);
        
        return build(0,preorder.length-1,0,postorder.length-1);
    }
    private TreeNode build(int preStart,int preEnd,int postStart,int postEnd){
        if(preStart>preEnd) return null; //empty range
        
        int rootVal = pre[preStart]; //curr root
        TreeNode root = new TreeNode(rootVal);

        if(preStart==preEnd) return root;

        //The next element in preorder is the root of the Left Subtree
        int leftRootVal = pre[preStart + 1];

        int indexInPost=map.get(leftRootVal);
        int len_left=indexInPost-postStart+1;

        root.left = build(
            preStart + 1,              // New preStart (skip current root)
            preStart + len_left,       // New preEnd (preStart + len_left elements)
            postStart,                 // New postStart
            postStart + len_left - 1   // New postEnd (len_left elements in postorder)
        );
        root.right = build(
            preStart + len_left + 1,   // New preStart (skip root and left subtree)
            preEnd,                    // New preEnd (rest of the current pre-range)
            postStart + len_left,      // New postStart (skip left subtree)
            postEnd - 1                // New postEnd (skip current root, which is postEnd)
        );
        return root;
    }
}