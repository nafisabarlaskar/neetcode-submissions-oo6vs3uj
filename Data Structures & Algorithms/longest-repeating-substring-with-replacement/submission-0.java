class Solution {
    public int characterReplacement(String s, int k) {
        int count[] = new int[26], max = 0, longest = 0, right = 0, left = 0;
        while (right < s.length()){
            int index = s.charAt(right) - 'A';
            count[index]++;
            max = Math.max(max, count[index]);
            if (right - left + 1 - max > k){
                count[s.charAt(left++) - 'A']--;
            }

            longest = right - left + 1;
            right++;
        }

        return longest;
    }
}
