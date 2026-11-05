import java.util.Arrays;

public class LongestConsecutiveSequenceSortingPractice {

    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longest = 1;
        int current = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] == nums[i - 1] + 1) {
                current++;
            } else {
                current = 1;
            }

            longest = Math.max(longest, current);
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive(nums));
    }
}
