public class LongestSubarrayOfOnesAfterDeletingOneElementPractice {

    public static int longestSubarray(int[] nums) {

        int left = 0;
        int zeros = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            // Count zeros
            if (nums[right] == 0) {
                zeros++;
            }

            // Allow maximum one zero
            while (zeros > 1) {

                if (nums[left] == 0) {
                    zeros--;
                }

                left++;
            }

            // Subtract 1 because exactly one element must be deleted
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 0, 1};

        System.out.println(longestSubarray(nums));
    }
}
