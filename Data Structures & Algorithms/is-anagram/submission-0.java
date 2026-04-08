class Solution {
    public boolean isAnagram(String s, String t) {
        int[] ch1 = new int[26], ch2 = new int[26];
        if (s.length() != t.length()){
            return false;
        }

        for (char c : s.toCharArray()){
            ch1[c - 'a']++;
        }

        for (char c : t.toCharArray()){
            ch2[c - 'a']++;
        }

        return Arrays.equals(ch1, ch2);
    }
}
