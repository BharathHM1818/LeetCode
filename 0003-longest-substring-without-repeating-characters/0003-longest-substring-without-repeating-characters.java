class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0, left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right=0; right<n; right++)
        {
            char ch = s.charAt(right);
            if(map.containsKey(ch))
            {
                left = Math.max(map.get(ch) + 1, left);
            }
            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}