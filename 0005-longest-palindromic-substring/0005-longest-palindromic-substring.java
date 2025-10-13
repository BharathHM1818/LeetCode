class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0) return "";

        int start = 0, maxLen = 1;

        for(int i=0; i<n; i++)
        {
            int left = i, right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right))
            {
                int len = right - left + 1;
                if(len > maxLen)
                {
                    start = left;
                    maxLen = len;
                }
                left--;
                right++;
            }

            left = i; right = i + 1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right))
            {
                int len = right - left + 1;
                if(len > maxLen)
                {
                    start = left;
                    maxLen = len;
                }
                left--;
                right++;
            }
        }

        String ans = "";

        for(int i=start; i<start + maxLen; i++)
        {
            ans += s.charAt(i);
        }
        return ans;
    }
}