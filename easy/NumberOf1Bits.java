public class NumberOf1Bits {

    public static int hammingWeight(int n) {

        int count = 0;

        while (n != 0) {

            n = n & (n - 1);

            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        int n = 11;

        int result = hammingWeight(n);

        System.out.println("Number of 1 Bits: " + result);
    }
}
