public class KthMissingPositiveNumber {

    public static int findKthPositive(int[] arr, int k) {

        int number = 1;

        while (k > 0) {

            boolean found = false;

            for (int value : arr) {

                if (value == number) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                k--;
            }

            if (k == 0) {
                return number;
            }

            number++;
        }

        return number;
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;

        int result = findKthPositive(arr, k);

        System.out.println(
                "Kth Missing Positive Number: " + result
        );
    }
}
