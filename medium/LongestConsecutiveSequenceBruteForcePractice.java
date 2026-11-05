public class LongestConsecutiveSequenceBruteForcePractice {

    public static int longestConsecutive(int[] nums) {

        int longest = 0;

        for (int num : nums) {

            int current = num;
            int count = 1;

            while (contains(nums, current + 1)) {
                current++;
                count++;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }

    public static boolean contains(int[] nums, int target) {

        for (int num : nums) {

            if (num == target) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive(nums));
    }
}
