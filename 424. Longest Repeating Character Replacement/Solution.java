//Time Complexity: O(n)
class Solution {
    public int characterReplacement(String s, int k) {

        //Approach 1

        //Insted of using HashMap we can use an array with size of 26 for each Character
        //Note if we take a Character value and subtract 'A' charater it will give us the subtraction of their ASCI(unicode) number of this Character. So 'A' - 'A' will return 0 as A:65. Similarly 'B' - 'A' will give 1 as B:66 and A:65. This way we don't need to use HashMap.
        int []map = new int[26];
        //left pointer of Sliding Window and r we will interate
        int l = 0;

        int maxlen = 0;
        int largest_frequency=0;

        for(int r=0;r<s.length();r++)
        {
            //for each character at r we will add its frequency to our map
            map[s.charAt(r)-'A']++;

            //We are concerned only about the largest fre so we will set it onces and for every new value will we just take max of it so that we don't need to find the largest value form our map array again and again.
            largest_frequency=Math.max(map[s.charAt(r)-'A'],largest_frequency);

            //we will check if the length of the window - largest frequeny is > k or not
            if(((r-l+1)-largest_frequency)>k)
            {
                //As the window size - largest_freq gives us all non matching elements and as they are greater than k we need to now proceed with of left pointer so as to find other possible cases.
                //we will decreament the freq first of this left character
                map[s.charAt(l)-'A']--;
                l++;
            }

            //Now this gives the valid window which will give the all same values and now we need to compare it with our maxlen. if its > maxlen then this will be our maxlen
            maxlen= Math.max(maxlen,(r-l+1));
        }   

        return maxlen;


        
        //Secong Approach with using HashMap 
        // //We will maintain a hashmap for frequency
        // HashMap<Character,Integer> map = new HashMap<>();

        // int l = 0;
        // int res = 0;
        
        // for(int r=0;r<s.length();r++)
        // {
        //     map.put(s.charAt(r), 1+map.getOrDefault(s.charAt(r),0));
        //     while(((r-l+1) - Collections.max(map.values()))>k)
        //     {
        //         map.put(s.charAt(l), map.getOrDefault(s.charAt(l),0)-1);
        //         l+=1;
        //     }
        //     res = Math.max(res, r-l+1);
        // }

        // return res;
    }
}
