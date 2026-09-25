public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        // Every element itself is a subsequence of length 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int longest = 1;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {

                    dp[i] = Math.max(
                            dp[i],
                            dp[j] + 1
                    );
                }
            }

            longest = Math.max(longest, dp[i]);
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int result = lengthOfLIS(nums);

        System.out.println(
                "Longest Increasing Subsequence: " + result
        );
    }
}
