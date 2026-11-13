import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsKPractice {

    public static int maxSubArrayLen(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            int required = prefixSum - k;

            if (map.containsKey(required)) {

                int length = i - map.get(required);

                maxLength = Math.max(maxLength, length);
            }

            // Store only the first occurrence
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;

        System.out.println(maxSubArrayLen(nums, k));
    }
}
