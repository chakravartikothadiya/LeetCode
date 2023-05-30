//Time Complexity: O(log(n))

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left<=right)
        {
            int mid = left + (right - left)/2;
            
            //base condition
            if(nums[mid]==target)
                return mid;
            
            //If not them we check for strictly increaseing side (Atleast one side i.e. left or rigth will be always strictly increasing)
            if(nums[mid]>=nums[left]) //left side is increasing
            {
                if(target>=nums[left] && target<=nums[mid]) //Now check if target lies in this side of range
                {
                    right = mid - 1; // If it lies then we eliminate right side
                }
                else
                {
                    left = mid + 1; // Else we eliminate left side
                }
            }
            else // right side is increasing
            {
                if(target>=nums[mid] && target<=nums[right]) //Now check if target lies in this side of range
                {
                    left  = mid + 1;
                }
                else
                {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
