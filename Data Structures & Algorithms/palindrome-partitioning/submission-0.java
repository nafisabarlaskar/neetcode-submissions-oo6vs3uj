class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        dfs(s, result, dp, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(String s, List<List<String>> result, boolean[][] dp, List<String> list, int start){
        if (start >= s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++){
            if (s.charAt(start) == s.charAt(i) && (i - start < 3 || dp[start + 1][i - 1])){
                dp[start][i] = true;
                list.add(s.substring(start, i + 1));
                dfs(s, result, dp, list, i + 1);
                list.removeLast();
            }
        }
    }
}
