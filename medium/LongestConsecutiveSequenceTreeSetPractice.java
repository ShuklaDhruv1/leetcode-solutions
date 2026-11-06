import java.util.TreeSet;

public class LongestConsecutiveSequenceTreeSetPractice {

    public static int longestConsecutive(int[] nums) {

        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        int current = 0;
        Integer previous = null;

        for (int num : set) {

            if (previous != null && (long) num == (long) previous + 1) {
                current++;
            } else {
                current = 1;
            }

            longest = Math.max(longest, current);
            previous = num;
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive(nums));
    }
}
