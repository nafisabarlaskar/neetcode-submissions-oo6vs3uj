class Solution {
    Map<Integer, String> map;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> result = new ArrayList<>();
        if (digits.length() > 0){
            dfs(result, new StringBuilder(), digits, 0);
        }
        return result;
    }

    private void dfs(List<String> result, StringBuilder sb, String digits, int index){
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String str = map.get(digits.charAt(index) - '0');
        for (char c : str.toCharArray()){
            sb.append(c);
            dfs(result, sb, digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
