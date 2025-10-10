class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, right = 0;
        int maxFreq = 0, maxLen = 0;

        while(right < s.length())
        {
            count[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            while((right - left + 1) - maxFreq > k)
            {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}