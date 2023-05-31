//Time Complexity is: O(log(n) + log(m)) = O(log(m*n))
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bot = matrix.length-1;
       
        int col = matrix[0].length-1;
        //First Binary Search
        while(top<=bot)
        {
            int row = (top + (bot - top)/2);
            //Check if the target is lies within the row or a row before
            if(target<matrix[row][0])
            {
                bot=row - 1;
            }
            //Check if the target is lies within the row or a row after
            else if(target>matrix[row][col])
            {
                top=row + 1;
            }
            //If not the that means the target might lie in that row only
            else 
            {
                break;
            }
        }

        //If any other invalid case has caused to break with our while loop condition satifying
        if(!(top<=bot))
        {
            return false;
        }

        //We break if we find the target within that row without changing top and bot so here we can recompute that same row
        int row = (top + (bot - top)/2);
        int l = 0;
        int r = col;
        //Second normal binary search
        while(l<=r)
        {
            int m = l + (r-l)/2;
            if(matrix[row][m]<target)
            {
                l = m+1;
            }
            else if(matrix[row][m]>target)
            {
                r = m -1;
            }
            else 
            {
                return true;
            }
        }

        return false;

        
        //My Initial Attempt without any reference
    //     //First Binary Search 
    //     int l1 = 0;
    //     int r1 = matrix.length-1;
    //     int m1 = 0;
    //     int flag = 0;
    //     int flag2 = 0;
    //     int l2 = 0;
    //     int r2 = 0;

    //     if(r1==0)
    //     {
    //         System.out.println("Skip");
    //         m1=0;
    //         l1=0;
    //         r2=matrix[0].length-1;
    //         flag2 =1;
    //         flag = 1;
    //     }

    //     if(flag2==0)
    //     {
    //     while(l1<=r1)
    //     {
    //         System.out.println("hello");
    //         m1 = l1 + (r1 - l1)/2;
    //         if(matrix[m1][0]==target)
    //         {
    //             return true;
    //         }
    //         else if(m1<matrix.length-1 && matrix[m1][0]<target && matrix[m1+1][0]>target)
    //         {
    //             l2 = 0;
    //             r2 = matrix[m1].length-1;
    //             flag = 1;
    //             break;
    //         }
    //         else if(m1==matrix.length-1)
    //         {
    //             l2 = 0;
    //             r2 = matrix[m1].length-1;
    //             flag = 1;
    //             break;
    //         }
    //         else if(matrix[m1][0]<target)
    //         {
    //             l1 = m1 + 1;
    //         }
    //         else if(matrix[m1][0]>target)
    //         {
    //             r1 = m1 - 1;
    //         }
    //     }
    //     }

        
    //     //Second Binary Search
    //     if(flag==1)
    //     {
    //         System.out.println("Inside Second"+m1);
    //     while(l2<=r2)
    //     {
    //         int m2= l2 + (r2 -l2)/2;
    //         if(matrix[m1][m2]==target)
    //         {
    //             return true;
    //         }
    //         else if(matrix[m1][m2]<target)
    //         {
    //             l2 = m2 + 1;
    //         }
    //         else
    //         {
    //             r2 = m2 - 1;
    //         }
    //     }
    //     }

    //     return false;
    }
}
