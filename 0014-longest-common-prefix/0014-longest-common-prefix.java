class Solution {
    public String longestCommonPrefix(String[] strs) {
       if(strs == null || strs.length == 0) return "";

       String prefix = strs[0]; 
       int prefixLength = prefix.length();

       for(int i=1; i<strs.length; i++)
       {
            String current = strs[i];
            int j = 0;

            while(j < prefixLength && j < current.length() &&
            prefix.charAt(j) == current.charAt(j))
            {
                j++;
            }
           prefixLength = j;

           if(prefixLength == 0) return "";
       }

       String res = "";
       for(int i=0; i<prefixLength; i++)
       {
        res += prefix.charAt(i);
       }
       return res;
    }
}