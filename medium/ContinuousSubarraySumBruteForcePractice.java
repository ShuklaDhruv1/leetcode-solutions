
public class ContinuousSubarraySumBruteForcePractice {
    public static boolean checkSubarraySum(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {

            int sum = 0;

            for (int j = i; j < nums.length; j++) {

                sum += nums[j];

                int length = j - i + 1;

                if (length >= 2 && sum % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;

        System.out.println(checkSubarraySum(nums, k));
    }
}
