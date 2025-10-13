class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null) return "";
        int n = s.length();
        int m = t.length();
        if(m > n) return "";

        int[] freqS = new int[128];
        int[] freqT = new int[128];

        for(int i=0; i<m; i++)
        {
            char ch = t.charAt(i);
            freqT[ch]++;
        }

        int startIdx = 0, count = 0, left = 0;
        int minLen = Integer.MAX_VALUE;

        for(int right=0; right<n; right++)
        {
            char chRight = s.charAt(right);
            freqS[chRight]++;

            if(freqS[chRight] <= freqT[chRight])
            {
                count++;
            }

            while(count == m)
            {
                if(right - left + 1 < minLen)
                {
                    minLen = right - left + 1;
                    startIdx = left;
                }

                char chLeft = s.charAt(left);
                freqS[chLeft]--;

                if(freqS[chLeft] < freqT[chLeft])
                {
                    count--;
                }
                left++;
            }
        }

        if(minLen == Integer.MAX_VALUE) return "";

        String ans = "";

        for(int i=startIdx; i<startIdx + minLen; i++)
        {
            ans += s.charAt(i);
        }

        return ans;
    }
}