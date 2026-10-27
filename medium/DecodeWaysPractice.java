public class DecodeWaysPractice {

    public static int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];

        // Empty string ko decode karne ka ek way
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            // Last digit ko separately decode karo
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Last two digits ko ek saath decode karo
            int twoDigits =
                    (s.charAt(i - 2) - '0') * 10
                    + (s.charAt(i - 1) - '0');

            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "226";

        System.out.println(numDecodings(s));
    }
}
