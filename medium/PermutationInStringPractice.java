public class PermutationInStringPractice {

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Count characters of s1 and first window of s2
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // Compare first window
        if (matches(count1, count2)) {
            return true;
        }

        // Slide the window
        for (int right = s1.length(); right < s2.length(); right++) {

            // Add new character
            count2[s2.charAt(right) - 'a']++;

            // Remove old character
            count2[s2.charAt(right - s1.length()) - 'a']--;

            if (matches(count1, count2)) {
                return true;
            }
        }

        return false;
    }

    public static boolean matches(int[] a, int[] b) {

        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));
    }
}
