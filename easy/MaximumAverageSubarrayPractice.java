public class MaximumAverageSubarrayPractice {

    public static double findMaxAverage(int[] nums, int k) {

        int windowSum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // Slide the window
        for (int i = k; i < nums.length; i++) {

            windowSum += nums[i];
            windowSum -= nums[i - k];

            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {

        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        System.out.println(findMaxAverage(nums, k));
    }
}
