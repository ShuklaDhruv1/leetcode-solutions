import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] phone = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };

        backtrack(
                digits,
                0,
                "",
                phone,
                result
        );

        return result;
    }

    public static void backtrack(
            String digits,
            int index,
            String current,
            String[] phone,
            List<String> result) {

        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters =
                phone[digits.charAt(index) - '0'];

        for (char letter : letters.toCharArray()) {

            backtrack(
                    digits,
                    index + 1,
                    current + letter,
                    phone,
                    result
            );
        }
    }

    public static void main(String[] args) {

        String digits = "23";

        List<String> result =
                letterCombinations(digits);

        System.out.println(
                "Letter Combinations: " + result
        );
    }
}
