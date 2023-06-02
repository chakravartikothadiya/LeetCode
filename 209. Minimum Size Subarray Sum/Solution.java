//Time Complexity: Although it seems we are using a while loop inside for loop it will only interate the left pointer so the time complexity will ve O(n)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //We solve this problem with sliding window

        //left pointer
        int l = 0;

        //Maintain a total sum
        int total = 0;
        int min = Integer.MAX_VALUE;
        

        //We interate the right pointer till total<target
        //We will keep on adding their sum to total
        //Once we get the total>=target, that mean we get one of the valid solution and now compare its length with min and select the min of them.
        //Now we can interate the left pointer till this condition is satified (total>=target) so as to find any other possible better solution
        //while doing this we will discard this left element from the total as well
        for(int r=0;r<nums.length;r++)
        {
            total+=nums[r];
            while(total>=target)
            {
                min = Math.min(r-l+1,min);
                total-= nums[l];
                l+=1;
            }
        }


        if(min == Integer.MAX_VALUE)
        {
            return 0;
        }
        else
        {
            return min;
        }
    }
}
