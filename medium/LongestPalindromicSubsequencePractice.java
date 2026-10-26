public class LongestPalindromicSubsequencePractice {

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        // Single character is always a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Process substrings from shorter to longer
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {

                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2;

                    if (len > 2) {
                        dp[i][j] += dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = Math.max(
                        dp[i + 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "bbbab";

        System.out.println(longestPalindromeSubseq(s));
    }
}
