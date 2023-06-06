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

 //Time Complexity: O(n) Space Complexity: O(n)
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root==null)
        {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int counter = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> currLevel = new ArrayList<>();
                
            while(size>0)
            {
                TreeNode curr = q.poll();
                currLevel.add(curr.val);

                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
                size--;
            }
            if(counter%2==0)
            {
                result.add(currLevel);
            }
            else
            {
                //reverse based on the counter if even or not
                Collections.reverse(currLevel);
                result.add(currLevel);
            }
            counter++;  
        }
        return result;
    }
}
