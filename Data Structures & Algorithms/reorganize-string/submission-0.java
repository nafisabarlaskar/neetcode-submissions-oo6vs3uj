class Solution {
    public String reorganizeString(String s) {
        int maxFreq = 0, maxLetter = 0, freq[] = new int[26];
        for (char c : s.toCharArray()){
            freq[c - 'a']++;
            if (freq[c - 'a'] >= maxFreq) {
                maxFreq = freq[c - 'a'];
                maxLetter = c - 'a';
            }
        }

        if (maxFreq > (s.length() + 1)/2){
            return "";
        }

        char[] result = new char[s.length()];
        int idx = 0;
        while (freq[maxLetter] > 0){
            result[idx] = (char)(maxLetter + 'a');
            idx += 2;
            freq[maxLetter]--;
        }

        for (int i = 0; i < 26; i++){
            while (freq[i] > 0){
                if (idx >= s.length()){
                    idx = 1;
                }

                result[idx] = (char)(i + 'a');
                idx += 2;
                freq[i]--;
            }
        }

        return new String(result);
    }
}