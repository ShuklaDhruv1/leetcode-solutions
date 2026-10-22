
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementIIPractice {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;

            while (!stack.isEmpty()
                    && nums[index] > nums[stack.peek()]) {

                int previousIndex = stack.pop();
                result[previousIndex] = nums[index];
            }

            if (i < n) {
                stack.push(index);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1};
        int[] nums2 = {1, 2, 3, 4, 3};

        System.out.println(
                Arrays.toString(nextGreaterElements(nums1))
        );

        System.out.println(
                Arrays.toString(nextGreaterElements(nums2))
        );
    }
}
