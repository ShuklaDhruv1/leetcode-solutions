public class CountingBits {

    public static int[] countBits(int n) {

        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            result[i] = result[i >> 1] + (i & 1);
        }

        return result;
    }

    public static void main(String[] args) {

        int n = 5;

        int[] result = countBits(n);

        System.out.print("Counting Bits: ");

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
