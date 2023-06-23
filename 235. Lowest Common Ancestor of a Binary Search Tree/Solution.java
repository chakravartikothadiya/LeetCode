/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


 //Here we don't actually use DFS. Insted we will just check for each level and make the decision of either going only right or only left or simply returning. This will omit entire sibtress traversal.and we can traverse with a time complexity of O(logn).

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr!=null)
        {
            // if(curr.val == p.val || curr.val == q.val)
            // {
            //     return curr;
            // }
            // if(curr.val < p.val && curr.val > q.val || curr.val > p.val && curr.val <q.val)
            // {
            //     return curr;
            // }


            //We simply check if both q and p lie on the right or left and traverse accordingly.
            if(curr.val < p.val && curr.val < q.val)
            {
                curr = curr.right;
            }
            else if(curr.val > p.val && curr.val > q.val)
            {
                curr = curr.left;
            }
            //If they don't lie on same side that means either the curr is p or q or it is the middle having p and q on either sides so in any case our solutions is curr so we return it
            else{
                return curr;
            }
        }
        return null;
    }
}
