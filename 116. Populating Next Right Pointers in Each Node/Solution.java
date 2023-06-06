/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

//Time Complexity: O(n) Space Complexity: O(n)

class Solution {
    public Node connect(Node root) {
        //We will give ref of root to head so that we can return it
        Node head = new Node();
        head = root;

        //For BFS we use Queue
        Queue<Node> q = new LinkedList<>();
        if(root==null)
        {
            return null;
        }
        //Add the root
        q.add(root);


        while(!q.isEmpty())
        {
            //For level identification we will use size of the queue as this will change according to each level
            int size = q.size();
           
                while(size>0)
                {
                    //Pop the first elem in the queue
                    Node curr = q.poll();
                    //If it has right and left child add it to the queue 
                    if(curr.left!=null) q.add(curr.left);
                    if(curr.right!=null) q.add(curr.right);

                    //New node of the next node
                    Node next;

                    //This is for the last node in that level so that even though the queue is not empty and full with next level elements it will ignore the peek and assign null
                    if(size==1)
                    {
                        next = null;
                    }
                    else
                    {
                        //IMP we peek the elem and not POLL cause we will process it in next loop
                        next = q.peek();
                    }
                  
                    curr.next = next;
                    size--;
                }
        }
        return head;
    }
}
