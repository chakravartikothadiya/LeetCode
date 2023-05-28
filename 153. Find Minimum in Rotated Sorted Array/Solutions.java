class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0)
        {
            return 0;
        }
        if(nums.length==1)
        {
            return nums[0];
        }
        int left=0;
        int right= nums.length - 1;
        while (left <= right)
        {
            int mid = left + (right - left)/2;
            
            //base condition if we are right on that element then just return (For index out of bound we consider mid>0) (*[5,6,7,1,2,3,4] this array will follow this condition*)
            if(mid>0 && nums[mid]<nums[mid-1])
            {
                return nums[mid];
            }
            //In this case we check if the element belongs to the left sorted array or the right one. If it belongs to the left one we discard the left elements and consider new array with right elements only and the nums[mid]>nums[right] condition is if the array is not rotated at all (* [3,4,5,1,2] and [1,2,3,4,5] these arrays will follow this condition*)
            else if(nums[left] <= nums[mid] && nums[mid]>nums[right])
            {
                left = mid + 1;
            }
            //Else if the element lies in the left then we will discard the right part (*[7,8,9,1,2,3,4,5,6] this array will follow this condition*)
            else {
                right = mid - 1;
            }
        }

        //Now as we had ignored the mid<=0 condition, if thats the case then our asn should be nums[left]
        return nums[left];
    }
}
