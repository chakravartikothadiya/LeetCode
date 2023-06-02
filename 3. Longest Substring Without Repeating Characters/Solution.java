// Time Complexity: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //We will solve this using sliding window

        //We will use HashSets to store element in it and check if it is already present in it. If it is that means its repeated. This will basically store all character including ' ','!' etc.
        
        HashSet<Character> set = new HashSet<>();

        //left pointer
        int l = 0;
        int longest_substring=0;

        for(int r = 0; r< s.length(); r++)
        {
            if(set.contains(s.charAt(r)))
            {
                //If it already contains then will go on iterating the left pointer till we find the same element. And then we will inc left by 1 and start the similar process form there
                while(s.charAt(l)!=s.charAt(r))
                {
                    set.remove(s.charAt(l));
                    l+=1;
                }
                l+=1;
            }
            else
            {
                set.add(s.charAt(r));
            }
            
            longest_substring = Math.max((r-l+1),longest_substring);
        }

        return longest_substring;
    }
}   
