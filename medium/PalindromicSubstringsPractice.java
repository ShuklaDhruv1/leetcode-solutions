public class PalindromicSubstringsPractice {

    public static int countSubstrings(String s) {
        int count = 0;

        for (int center = 0; center < s.length(); center++) {

            // Odd-length palindromes
            count += expandAroundCenter(s, center, center);

            // Even-length palindromes
            count += expandAroundCenter(s, center, center + 1);
        }

        return count;
    }

    private static int expandAroundCenter(
            String s, int left, int right) {

        int count = 0;

        while (left >= 0
                && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            count++;

            left--;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "aaa";

        System.out.println(countSubstrings(s));
    }
}
