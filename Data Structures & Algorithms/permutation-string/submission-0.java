class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }

        int[] mp1 = new int[26], mp2 = new int[26];
        for (int i = 0; i < s1.length(); i++){
            mp1[s1.charAt(i) - 'a']++;
            mp2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++){
            if (Arrays.equals(mp1, mp2)){
                return true;
            }

            mp2[s2.charAt(i + s1.length()) - 'a']++;
            mp2[s2.charAt(i)- 'a']--;
        }

        return Arrays.equals(mp1, mp2);
    }
}
