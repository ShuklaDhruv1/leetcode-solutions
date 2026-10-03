public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {

        int currentMax = nums[0];
        int currentMin = nums[0];

        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];

            // Negative number can swap max and min
            if (num < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            currentMax = Math.max(
                    num,
                    currentMax * num
            );

            currentMin = Math.min(
                    num,
                    currentMin * num
            );

            result = Math.max(
                    result,
                    currentMax
            );
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {
            2, 3, -2, 4
        };

        int result = maxProduct(nums);

        System.out.println(
                "Maximum Product: " + result
        );
    }
}
