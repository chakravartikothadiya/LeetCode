//Time Complexity: O(n)

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int window_size = s1.length();

        if(s1.length()>s2.length()||s1.length()==0)
        {
            return false;
        }
        if(s2.length()==0)
        {
            return true;
        }
        //We will take two arrays as frequency tables for both the strings
        int arr1[] = new int[26];
        int arr2[] = new int[26];

        for(int i=0;i<window_size;i++)
        {
            //We will fill both the arrays as per their frequency
            arr1[s1.charAt(i)-'a']++;
            arr2[s2.charAt(i)-'a']++;
        }

        //Now we will take 2 pointers for the windoe and go on checking if both the frequency arrays match or not
        int l = 0;
        int r = l+window_size-1;

        while(r<s2.length()-1)
        {
            if(Arrays.equals(arr1,arr2))
            {
                return true;
            }
            arr2[s2.charAt(l)-'a']--;
            l++;

            r++;
            arr2[s2.charAt(r)-'a']++;
        }

         if(Arrays.equals(arr1,arr2))
         {
            return true;
         }
         else
         {
            return false;
         }
    }
}
