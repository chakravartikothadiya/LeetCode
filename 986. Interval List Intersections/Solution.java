//Name: Chakravarti Kothadiya

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        //We will add all the intervals in a list to make the process easier
        List<int[]> l1 = new ArrayList<>();

        //Run a while loop traversing both the Lists till their size n1 and n2
        int n1=firstList.length;
        int n2=secondList.length;

        //Take 2 pointer i and j for firstList and secondList respectively
        int i=0,j=0;
        while(i<n1 && j<n2)
        {
            //We will take 4 pointers start1 (s1) and end1 (e2) for firstList intervals and start2 (s2) and end2 (e2) for the secondList intervals
            int s1 = firstList[i][0];
            int e1 = firstList[i][1];
            int s2 = secondList[j][0];
            int e2 = secondList[j][1];

            //Check if their is an overlap between the 2 intervals
            //Check if either s1 lies between s2 and e2 OR s2 lies between s1 and e1
            if((s1<=s2 && s2<=e1) || (s2<=s1 && s1<=e2))
            {
                //If intersect then take the highest start value and lowest end value intersect interval and add it to the list
                int curr[] = {Math.max(s1,s2),Math.min(e1,e2)};
                l1.add(curr);
            }
                 //If e1 < e2 then increment i as it is lower non intersecting interval else j++
                if(e1<e2) 
                {
                    i++;
                }
                else
                {
                    j++;
                }
        }
        return l1.toArray(new int[l1.size()][]);
    }
}
