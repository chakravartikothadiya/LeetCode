/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Time Complexity is: O(n)
//Space Complexity is: O(n)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Firts we check if the root has is either p or q. If it is then we simply return it

        //If the root is null then we will return null
        if(root==null)
        {
            return null;
        }
        
        //if the root is either p or q then we return that node
        if(root.val==p.val || root.val==q.val)
        {
            return root;
        }
        
        //We will traverse left and right nodes based on DFS
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        //Now if left is null then we don't want to go in that direction and most likely our solution will be on the right so we simply rertun right
        if(left==null)
        {
            return right;
        }
        //Similarly we do it for rigth node as well.
        //If both of them are null then still it will basically return null only.
        if(right==null)
        {
            return left;
        }

        //This is the condition when we have reached a node where we have both right and left values return from both sub trees and which are not null.
        return root;
    }
}
