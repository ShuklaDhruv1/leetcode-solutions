public class MissingNumber {

    public static int missingNumber(int[] nums) {

        int n = nums.length;
        int result = n;

        for (int i = 0; i < nums.length; i++) {
            result = result ^ i ^ nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {3, 0, 1};

        int result = missingNumber(nums);

        System.out.println("Missing Number: " + result);
    }
}
