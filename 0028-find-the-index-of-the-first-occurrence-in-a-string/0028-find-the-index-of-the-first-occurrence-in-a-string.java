class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int i=0, j=0;
        int[] lps = computeLPS(needle);
        while(i < haystack.length())
        {
            if(haystack.charAt(i) == needle.charAt(j))
            {
                i++; j++;
                if(j == needle.length()) return i - j;
            }
            else if(j != 0)
            {
               j = lps[j - 1];
            }
            else
            {
                i++;
            }
        }
        return -1;
    }

    public int[] computeLPS(String pattern)
    {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        for(int i=1;i<m;)
        {
            if(pattern.charAt(i) == pattern.charAt(len))
            {
                lps[i++] = ++len;
            }
            else if(len != 0)
            {
                len = lps[len-1];
            }
            else
            {
                lps[i++] = 0;
            }
        }
        return lps;
    }
}