class Solution {
    public int characterReplacement(String s, int k) {
        int count[] = new int[26], longest = 0, max = 0, right = 0, left = 0;
        while (right < s.length()){
            int idx = s.charAt(right) - 'A';
            count[idx]++;
            max = Math.max(max, count[idx]);
            if (right - left + 1 - max > k){
                count[s.charAt(left++) - 'A']--;
            }

            longest = Math.max(longest, right++ - left + 1);
        }

        return longest;
    }
}
