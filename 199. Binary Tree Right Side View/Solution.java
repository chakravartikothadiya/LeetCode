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

 //Time Complexity: O(n)

 // This we can solve by BFS as for each level we will take the last element in the queue
class Solution {
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
        {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();

        //First we add root in Queue
        q.add(root);

        while(!q.isEmpty())
        {
            //Getting size of the quque for each level will help in identify elements in that level as other elements of other levels might also be present at the same time
            int size = q.size();

            while(size>0)
            {
                //For each level we will iterate the queue till we get the last element
                TreeNode curr = q.poll();
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
                if(size == 1)
                {
                    result.add(curr.val);
                }
                size--;
            }
        }

        return result;
    }
}
