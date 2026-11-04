import java.util.HashMap;

public class LongestArithmeticSubsequenceZeroDifferencePractice {

    public static int longestSubsequence(int[] arr, int difference) {

        HashMap<Integer, Integer> dp = new HashMap<>();

        int answer = 0;

        for (int num : arr) {

            int previous = num - difference;

            int length = dp.getOrDefault(previous, 0) + 1;

            dp.put(num, length);

            answer = Math.max(answer, length);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] arr = {5, 5, 5, 2, 2, 5};
        int difference = 0;

        System.out.println(longestSubsequence(arr, difference));
    }
}
