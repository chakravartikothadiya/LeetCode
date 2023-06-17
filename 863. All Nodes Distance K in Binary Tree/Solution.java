/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time Complexity is O(n)
 // here we in each iteration will travers a node to the upside (parent) and left and right and add it to the queue. We will iterate this based on the value of k. To check the parent of each node we will first create a HashMap where each node child will be mapped to its parent. This can be done with a function which will just go on traversing using DFS and add values to the HashMap. To make sure we don't visit the same node twice we will maintain a HAshSet called visited and for each node we visit we will add it to this set.

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //We will take a HashMap to maintain parents for each child so we can also go in the parents direction
        HashMap<TreeNode,TreeNode> hm = new HashMap<>();
        
        //This function will create the Parent Child Map
        createMap(root, hm);

        //We will maintain a set for visited nodes
        HashSet<TreeNode> visited = new HashSet<>();

        //Now we wil go on BFS traversal for that we will have another queue
        Queue<TreeNode> q = new LinkedList<>();

        //We will also have a List of final result
        ArrayList<Integer> result = new ArrayList<>();

        //Firts we add the root element to the quque
        if(root==null)
        {
            return result;
        }

        //We will add the root
        q.add(target);

        while(!q.isEmpty())
        {
            int size = q.size();

            while(size>0)
            {
                TreeNode curr = q.poll();
                visited.add(curr);
                //Now we will check if k==0 
                if(k==0)
                {
                    result.add(curr.val);
                }
                //Check if the parent of the curr node is already visited and if the curr node has a parent or not. If not visited then add it to the queue
                if(hm.containsKey(curr) && !visited.contains(hm.get(curr)))
                {
                    q.add(hm.get(curr));
                }

                //Now we will check same for the left and right node as well
                if(curr.left!=null && !visited.contains(curr.left))
                {
                    q.add(curr.left);
                }

                if(curr.right!=null && !visited.contains(curr.right))
                {
                    q.add(curr.right);
                }

                size--;
            }
            k--;
            if(k<0)
            {
                break;
            }
        }

        return result;
    }

    public void createMap (TreeNode root, HashMap<TreeNode,TreeNode> hm)
    {
        if(root == null)
        {
            return;
        }

        if(root.left!=null)
        {
            hm.put(root.left, root);
        }
        if(root.right!=null)
        {
            hm.put(root.right, root);
        }
        createMap(root.left,hm);
        createMap(root.right,hm);
        return;
    }
    
}
