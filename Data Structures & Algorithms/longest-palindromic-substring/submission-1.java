class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++){
            int len = Math.max(palLen(s, i, i), palLen(s, i, i + 1));
            if (len > end - start){
                end = i + len/2;
                start = i - (len - 1)/2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int palLen(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            right++;
            left--;
        }

        return right - left - 1;
    }
}
