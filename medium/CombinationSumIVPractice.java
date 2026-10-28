public class CombinationSumIVPractice {

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        // Target 0 banane ka ek way: empty combination
        dp[0] = 1;

        for (int sum = 1; sum <= target; sum++) {
            for (int num : nums) {
                if (sum >= num) {
                    dp[sum] += dp[sum - num];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;

        System.out.println(combinationSum4(nums, target));
    }
}
