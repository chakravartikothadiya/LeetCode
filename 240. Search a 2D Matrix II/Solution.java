//Time Complexity: It will be O(m+n) as here in case of 18 will need to go all the way down and then all the way left.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    
      //Start from last column
      int c = matrix[0].length - 1;

      //Start from the first row
      int r = 0;
      //We will start from the first row last column as always compare the elements with target. If the target is larger we move downwards as only all elements to the bottom row will be greater than the current element and if the target is lesser then we move towards left as only all elements to the left of the current element will be always lesser.
      while (c>=0 && r<=matrix.length-1)
      {
          if(matrix[r][c]==target)
          {
              return true;
          }
          else if(matrix[r][c]>target)
          {
              c-=1;
          }
          else
          {
              r+=1;
          }
      }

      return false;
    }
}
