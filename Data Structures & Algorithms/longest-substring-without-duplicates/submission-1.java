class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, longest = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            if (map.containsKey(c)){
                left = Math.max(left, map.get(c));
            }

            longest = Math.max(right - left + 1, longest);
            right++;
            map.put(c, right);
        }

        return longest;
    }
}
