import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharactersPractice {

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);

            // Remove duplicate characters
            while (set.contains(current)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character
            set.add(current);

            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }
}
