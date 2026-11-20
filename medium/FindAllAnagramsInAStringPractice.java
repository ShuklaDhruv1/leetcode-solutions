import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAStringPractice {

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] countP = new int[26];
        int[] countS = new int[26];

        // Count characters of p and first window of s
        for (int i = 0; i < p.length(); i++) {
            countP[p.charAt(i) - 'a']++;
            countS[s.charAt(i) - 'a']++;
        }

        // Check first window
        if (matches(countP, countS)) {
            result.add(0);
        }

        // Slide the window
        for (int right = p.length(); right < s.length(); right++) {

            // Add new character
            countS[s.charAt(right) - 'a']++;

            // Remove old character
            countS[s.charAt(right - p.length()) - 'a']--;

            if (matches(countP, countS)) {
                result.add(right - p.length() + 1);
            }
        }

        return result;
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

        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));
    }
}
