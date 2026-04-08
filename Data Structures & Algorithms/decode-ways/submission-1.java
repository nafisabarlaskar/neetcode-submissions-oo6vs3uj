class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++){
            int first = Integer.parseInt(s.substring(i - 1, i)),
             second = Integer.parseInt(s.substring(i - 2, i));
            if (first > 0 && first < 10){
                dp[i] += dp[i - 1];
            }

            if (second > 9  && second < 27){
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
