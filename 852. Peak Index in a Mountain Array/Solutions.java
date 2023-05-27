class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int max=arr[0];
        int ind = 0;
        int left = 0;
        int right = arr.length-1;
        while(left<=right)
        {
            int mid = (left + right)/2;

            //This condition is to handle if the mid is leftmost element and there is no mid-1. mid will only be 0 if there are 2 elements left with l=0 and r=1
            if(mid==0)
            {
                return mid+1;
            }
            //This is the condition to handle if the mid is the rightmost element and there is no mid+1. mid will only be arr.length-1 if there are 2 elements left with l=2nd last index and r= last index
            else if(mid==arr.length-1)
            {
                return mid-1;
            }
            //Using Binary Search check if both the right and left elements of the mid are lesser than mid
            else if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
            {
                return mid;
            }
            else if(arr[mid]<arr[mid-1])
            {
                right = mid - 1;
            }
            else 
            {
                left = mid + 1;
            }
        }
        return -1;
    }
}
