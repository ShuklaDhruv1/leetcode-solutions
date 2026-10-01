import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static boolean wordBreak(
            String s,
            List<String> wordDict) {

        Set<String> words = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] &&
                    words.contains(s.substring(j, i))) {

                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {

        String s = "leetcode";

        List<String> wordDict = List.of(
                "leet",
                "code"
        );

        boolean result =
                wordBreak(s, wordDict);

        System.out.println(
                "Can Be Segmented: " + result
        );
    }
}
