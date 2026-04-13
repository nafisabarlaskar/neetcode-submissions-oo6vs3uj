class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length(), dp[] = new int[n];
        Arrays.fill(dp, -1);
        return dfs(s, wordDict, n - 1, dp);
    }

    private boolean dfs(String s, List<String> dict, int index, int[] dp){
        if (index < 0){
            return true;
        }

        if (dp[index] != -1){
            return dp[index] == 1;
        }

        for (String str : dict){
            if (index - str.length()  + 1 < 0){
                continue;
            }

            if (s.substring(index - str.length() + 1, index + 1).equals(str)
             && dfs(s, dict, index - str.length(), dp)){
                dp[index] = 1;
                return true;
            }
        }

        dp[index] = 0;
        return false;
    }
}
