public class SubarraySumEqualsKPrefixArrayPractice {

    public static int subarraySum(int[] nums, int k) {

        int n = nums.length;

        int[] prefix = new int[n + 1];

        // Build prefix sum array
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int count = 0;

        // Check every possible subarray
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j <= n; j++) {

                int sum = prefix[j] - prefix[i];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int k = 3;

        System.out.println(subarraySum(nums, k));
    }
}
