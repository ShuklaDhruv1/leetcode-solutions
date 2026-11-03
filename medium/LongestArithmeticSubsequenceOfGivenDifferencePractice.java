import java.util.HashMap;

public class LongestArithmeticSubsequenceOfGivenDifferencePractice {

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
        int[] arr = {1, 2, 3, 4};
        int difference = 1;

        System.out.println(longestSubsequence(arr, difference));
    }
}
