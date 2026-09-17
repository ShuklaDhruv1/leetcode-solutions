public class JumpGame {

    public static boolean canJump(int[] nums) {

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};

        boolean result = canJump(nums);

        System.out.println("Can Reach Last Index: " + result);
    }
}
