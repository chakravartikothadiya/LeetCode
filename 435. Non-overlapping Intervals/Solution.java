//Name: Chakravarti Kothadiya
//Time Complexity: O(nlogn) 

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //Define a counter for the to be removed intervals
        int counter = 0;
        int start,end;

        //Sort the Array based on the starting index of each interval
        Arrays.sort(intervals, (arr1,arr2) -> Integer.compare(arr1[0],arr2[0]));    //Time Complexity will be O(nlogn)

        //Store the end value of the first interval in the list as previous end
        int prevEnd=intervals[0][1];

        //Now iterate a loop strating form 1st index intervals
        for(int i=1;i<intervals.length;i++)  //Time complexity will be O(n) where n is the size of the intervals array
        {
            start = intervals[i][0];
            end = intervals[i][1];
            
            //If it is not overlapping 
            if(start>=prevEnd)
            {
                prevEnd = end;
            }
            //If it is overlapping
            else
            {
                //We don't remove any interval we just inc the counter and set the Min of both ends (We take min cause the max one have high prob of overlapping with the next one compared to the min one)
                counter++;
                prevEnd = Math.min(prevEnd, end);
            }
        }
      
        return counter;
    }
}
