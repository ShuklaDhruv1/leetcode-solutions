public class HouseRobber {

    public static int rob(int[] nums) {

        int previousTwo = 0;
        int previousOne = 0;

        for (int money : nums) {

            int current = Math.max(
                    previousOne,
                    previousTwo + money
            );

            previousTwo = previousOne;
            previousOne = current;
        }

        return previousOne;
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 9, 3, 1};

        int result = rob(nums);

        System.out.println("Maximum Money: " + result);
    }
}
