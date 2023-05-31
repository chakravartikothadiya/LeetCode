//Time Complexity is O(log(n))
class Solution {
    public int findPeakElement(int[] nums) {
       int l = 0;
       int r = nums.length - 1;
       while(l<=r)
       {
           int m = l + (r-l)/2;
           //left neighbour greater
           if(m>0 && nums[m]<nums[m-1])
                r = m - 1;
           //right neighbour greater
           else if (m<nums.length-1 && nums[m]<nums[m+1])
                l = m + 1;
           //the mid is the peak
           else
                return m; 
       }
       return -1;
    }
}
