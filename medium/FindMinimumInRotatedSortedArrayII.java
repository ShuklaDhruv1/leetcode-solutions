public class FindMinimumInRotatedSortedArrayII {

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid =
                    left + (right - left) / 2;

            if (nums[mid] < nums[right]) {

                right = mid;

            } else if (nums[mid] > nums[right]) {

                left = mid + 1;

            } else {

                // Duplicate values
                right--;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

        int[] nums = {
            2, 2, 2, 0, 1
        };

        int result = findMin(nums);

        System.out.println(
                "Minimum Element: " + result
        );
    }
}
