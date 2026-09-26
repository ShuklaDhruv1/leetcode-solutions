public class PermutationInString {

    public static boolean checkInclusion(
            String s1,
            String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        if (matches(count1, count2)) {
            return true;
        }

        int left = 0;

        for (int right = s1.length();
             right < s2.length();
             right++) {

            count2[s2.charAt(right) - 'a']++;

            count2[s2.charAt(left) - 'a']--;

            left++;

            if (matches(count1, count2)) {
                return true;
            }
        }

        return false;
    }

    public static boolean matches(
            int[] count1,
            int[] count2) {

        for (int i = 0; i < 26; i++) {

            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean result = checkInclusion(s1, s2);

        System.out.println(
                "Permutation Found: " + result
        );
    }
}
