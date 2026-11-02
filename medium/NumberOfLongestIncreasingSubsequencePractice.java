public class NumberOfLongestIncreasingSubsequencePractice {

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        int[] count = new int[n];

        int maxLength = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            count[i] = 1;

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {

                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                    else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }

            if (dp[i] > maxLength) {
                maxLength = dp[i];
                answer = count[i];
            }
            else if (dp[i] == maxLength) {
                answer += count[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};

        System.out.println(findNumberOfLIS(nums));
    }
}
