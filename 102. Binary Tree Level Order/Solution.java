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

 //Time Complexity: O(n) and Space Complexity: O(n) 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
        {
            return result;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        //Add the root element first 
        q1.add(root);


        //We will go on trversing the queue until the queue is Empty
        while(!q1.isEmpty())
        {
            //Everytime we will iterate each level based on the size of the queue
            int size = q1.size();
            List<Integer> currentLevel = new ArrayList<>();
            while(size>0)
            {
                TreeNode curr = q1.poll();
                currentLevel.add(curr.val);
                if(curr.left!=null)
                {
                    q1.add(curr.left);
                }
                if(curr.right !=null)
                {
                    q1.add(curr.right);
                }
                size--;
            }
            result.add(currentLevel);
        }
        return result;
    }
}
