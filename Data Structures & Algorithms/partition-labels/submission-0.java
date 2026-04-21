class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++){
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int left = 0, right = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            right = Math.max(right, lastIndex[s.charAt(i) - 'a']);
            if (right == i){
                result.add(i - left + 1);
                left = i + 1;
            }
        }

        return result;
    }
}
