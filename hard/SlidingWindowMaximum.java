import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(
            int[] nums,
            int k) {

        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        int[] result =
                new int[nums.length - k + 1];

        Deque<Integer> deque =
                new ArrayDeque<>();

        int resultIndex = 0;

        for (int right = 0;
             right < nums.length;
             right++) {

            // Remove indices outside the window
            while (!deque.isEmpty() &&
                   deque.peekFirst() <= right - k) {

                deque.pollFirst();
            }

            // Remove smaller elements
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()]
                        <= nums[right]) {

                deque.pollLast();
            }

            deque.offerLast(right);

            // Window is ready
            if (right >= k - 1) {

                result[resultIndex++] =
                        nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {
            1, 3, -1, -3, 5, 3, 6, 7
        };

        int k = 3;

        int[] result =
                maxSlidingWindow(nums, k);

        System.out.print(
                "Sliding Window Maximum: "
        );

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
