public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n == 1) return 1;

        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = 1;
        }

        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                dp[i][1] = dp[i - 1][0] + 1;
            } else if (arr[i] < arr[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
            }
            maxLen = Math.max(maxLen, Math.max(dp[i][0], dp[i][1]));
        }

        return maxLen;
    }
}