public class MinimumOperationsToReduceXToZeroPractice {

    public static int minOperations(int[] nums, int x) {

        int totalSum = 0;

        // Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum - x;

        // Special case
        if (target == 0) {
            return nums.length;
        }

        int left = 0;
        int currentSum = 0;
        int maxLength = -1;

        // Sliding Window
        for (int right = 0; right < nums.length; right++) {

            currentSum += nums[right];

            // Shrink window
            while (left <= right && currentSum > target) {
                currentSum -= nums[left];
                left++;
            }

            // Find longest subarray
            if (currentSum == target) {
                maxLength = Math.max(
                    maxLength,
                    right - left + 1
                );
            }
        }

        if (maxLength == -1) {
            return -1;
        }

        return nums.length - maxLength;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;

        System.out.println(minOperations(nums, x));
    }
}
