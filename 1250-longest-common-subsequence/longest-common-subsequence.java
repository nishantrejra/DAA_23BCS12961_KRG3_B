//- Use recursion + memoization (Top-Down Dynamic Programming) to compute the length of the Longest Common Subsequence (LCS).

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return count(0, 0, text1, text2, dp);
    }

    public static int count(int i, int j, String s, String t, int[][] dp) {
        if (i == s.length() || j == t.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = 1 + count(i + 1, j + 1, s, t, dp);
        } else {
            int x = count(i + 1, j, s, t, dp);
            int y = count(i, j + 1, s, t, dp);
            dp[i][j] = Math.max(x, y);
        }

        return dp[i][j];
    }
}