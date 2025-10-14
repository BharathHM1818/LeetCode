class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp  = new boolean[n+1];
        dp[0] = true;

        for(int i=1; i<=n; i++)
        {
            for(String w : wordDict)
            {
                int start = i - w.length();
                if(start >= 0 && dp[start] && match(s, start, w))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public boolean match(String s, int start, String word)
    {
        if(start + word.length() > s.length()) return false;
        for(int i=0; i<word.length(); i++)
        {
            if(s.charAt(start + i) != word.charAt(i)) return false;
        }
        return true;
    }
}