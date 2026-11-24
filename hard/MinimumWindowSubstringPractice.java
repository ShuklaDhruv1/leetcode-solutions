public class MinimumWindowSubstringPractice {

    public static String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] count = new int[128];

        // Store frequency of required characters
        for (char c : t.toCharArray()) {
            count[c]++;
        }

        int left = 0;
        int required = t.length();

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);

            // Character is still required
            if (count[current] > 0) {
                required--;
            }

            count[current]--;

            // All required characters found
            while (required == 0) {

                int windowLength = right - left + 1;

                // Update minimum window
                if (windowLength < minLength) {
                    minLength = windowLength;
                    start = left;
                }

                // Remove left character
                char removed = s.charAt(left);

                count[removed]++;

                if (count[removed] > 0) {
                    required++;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}
