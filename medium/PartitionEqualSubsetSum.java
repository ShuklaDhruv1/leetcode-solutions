public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for (int num : nums) {

            for (int sum = target; sum >= num; sum--) {

                dp[sum] =
                        dp[sum] || dp[sum - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {

        int[] nums = {
            1, 5, 11, 5
        };

        boolean result = canPartition(nums);

        System.out.println(
                "Can Partition: " + result
        );
    }
}
