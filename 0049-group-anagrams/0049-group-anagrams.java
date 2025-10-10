class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String, List<String>> map = new HashMap<>();

       for(int w=0; w<strs.length; w++)
       {
       String s = strs[w];
       int[] freq = new int[26];

       for(int i=0; i<s.length(); i++)
       {
        char ch = s.charAt(i);
        freq[ch - 'a']++;
       }

       String key = "";
       for(int i=0; i<26; i++)
       {
        key += freq[i] + "#";
       }

       if(!map.containsKey(key))
       {
        map.put(key, new ArrayList<>());
       }
       map.get(key).add(s);
       }

       List<List<String>> result = new ArrayList<>();
       for(List<String> group : map.values()) 
       {
        result.add(group);
       }
       return result;
    }
}