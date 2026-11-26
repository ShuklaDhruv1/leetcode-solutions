public class LongestRepeatingCharacterReplacementPractice {

    public static int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Count current character
            int index = s.charAt(right) - 'A';

            freq[index]++;

            // Update maximum frequency
            maxFreq = Math.max(maxFreq, freq[index]);

            // Shrink window if replacements exceed k
            while ((right - left + 1) - maxFreq > k) {

                freq[s.charAt(left) - 'A']--;

                left++;
            }

            // Update maximum length
            maxLength = Math.max(
                maxLength,
                right - left + 1
            );
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        System.out.println(characterReplacement(s, k));
    }
}
