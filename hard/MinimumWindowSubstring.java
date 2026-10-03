import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String minWindow(
            String s,
            String t) {

        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> required =
                new HashMap<>();

        for (char c : t.toCharArray()) {
            required.put(
                    c,
                    required.getOrDefault(c, 0) + 1
            );
        }

        Map<Character, Integer> window =
                new HashMap<>();

        int left = 0;
        int formed = 0;

        int requiredCount = required.size();

        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        for (int right = 0;
             right < s.length();
             right++) {

            char c = s.charAt(right);

            window.put(
                    c,
                    window.getOrDefault(c, 0) + 1
            );

            if (required.containsKey(c) &&
                window.get(c).intValue()
                        == required.get(c).intValue()) {

                formed++;
            }

            while (formed == requiredCount) {

                if (right - left + 1 < minLength) {

                    minLength =
                            right - left + 1;

                    minLeft = left;
                }

                char leftChar =
                        s.charAt(left);

                window.put(
                        leftChar,
                        window.get(leftChar) - 1
                );

                if (required.containsKey(leftChar) &&
                    window.get(leftChar)
                            < required.get(leftChar)) {

                    formed--;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(
                minLeft,
                minLeft + minLength
        );
    }

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result =
                minWindow(s, t);

        System.out.println(
                "Minimum Window: " + result
        );
    }
}
