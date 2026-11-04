import java.util.HashMap;

public class LongestArithmeticSubsequencePositiveDifferencePractice {

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

        int[] arr = {1, 3, 5, 7, 9};
        int difference = 2;

        System.out.println(longestSubsequence(arr, difference));
    }
}
