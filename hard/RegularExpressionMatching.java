public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {

        Boolean[][] memo =
                new Boolean[s.length() + 1][p.length() + 1];

        return solve(s, p, 0, 0, memo);
    }

    public static boolean solve(
            String s,
            String p,
            int i,
            int j,
            Boolean[][] memo) {

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (j == p.length()) {
            return i == s.length();
        }

        boolean firstMatch =
                i < s.length() &&
                (s.charAt(i) == p.charAt(j) ||
                 p.charAt(j) == '.');

        boolean result;

        if (j + 1 < p.length() &&
            p.charAt(j + 1) == '*') {

            result =
                    solve(s, p, i, j + 2, memo) ||
                    (firstMatch &&
                     solve(s, p, i + 1, j, memo));

        } else {

            result =
                    firstMatch &&
                    solve(s, p, i + 1, j + 1, memo);
        }

        memo[i][j] = result;

        return result;
    }

    public static void main(String[] args) {

        String s = "aab";
        String p = "c*a*b";

        boolean result = isMatch(s, p);

        System.out.println(
                "Pattern Match: " + result
        );
    }
}
