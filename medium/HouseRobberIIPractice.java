public class HouseRobberIIPractice {

    public static int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int firstExcluded = robRange(nums, 1, n - 1);
        int lastExcluded = robRange(nums, 0, n - 2);

        return Math.max(firstExcluded, lastExcluded);
    }

    private static int robRange(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};

        System.out.println(rob(nums));
    }
}
