public class MaximumSumCircularSubarrayPractice {

    public static int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        int maxSum = nums[0];
        int currentMax = 0;

        int minSum = nums[0];
        int currentMin = 0;

        for (int num : nums) {
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            totalSum += num;
        }

        // Agar saare numbers negative hain
        if (maxSum < 0) {
            return maxSum;
        }

        int circularSum = totalSum - minSum;

        return Math.max(maxSum, circularSum);
    }

    public static void main(String[] args) {
        int[] nums = {5, -3, 5};

        System.out.println(maxSubarraySumCircular(nums));
    }
}
