//Name: Chakravarti Kothadiya 
//Time Complexity: O(n)

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
    //We will create a list and go on adding our intervals to the solution list
    List<int[]> list = new ArrayList<>();

    int i =0, n = intervals.length;
    //1. We will travers all the intervals until they overlapp with the newInterval (Basically all the non-overlapping intervals to the left of newInterval)
    //Compare the last value of the intervals with the first value of the newInterval. If always less then they don't overlapp
    while(i < n && intervals[i][1]<newInterval[0])
    {
        list.add(intervals[i++]);
    }

    //2. Now if overlapping, before inserting the newInterval we will go on checking it with the next intervals till they don't overlapp
    while(i < n && intervals[i][0]<=newInterval[1]) // This condition will check if the intervals have not surpasssed the overlapping intervals to the next non-overlapping once
    {
        //Keep updating the newInterval until they overlapp and statisfy the above condition
        newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
        newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
        i++;
    }
    //Now once we get the final concludede newInterval we insert it into the list
    list.add(newInterval);

    //3. Finally we go on adding all the remaining intervals to the list
    while(i < n)
    {
        list.add(intervals[i++]);
    }


    //Convert the list into an array and return 
    return list.toArray(new int[list.size()][]);
    }
}
