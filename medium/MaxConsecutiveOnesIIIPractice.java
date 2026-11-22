public class MaxConsecutiveOnesIIIPractice {

    public static int longestOnes(int[] nums, int k) {

        int left = 0;
        int zeros = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            // Count zeros
            if (nums[right] == 0) {
                zeros++;
            }

            // Shrink window if zeros exceed k
            while (zeros > k) {

                if (nums[left] == 0) {
                    zeros--;
                }

                left++;
            }

            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        System.out.println(longestOnes(nums, k));
    }
}
