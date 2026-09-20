import java.util.HashSet;

public class HappyNumber {

    public static boolean isHappy(int n) {

        HashSet<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {

            seen.add(n);

            int sum = 0;

            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }

            n = sum;
        }

        return n == 1;
    }

    public static void main(String[] args) {

        int n = 19;

        System.out.println("Is Happy Number: " + isHappy(n));
    }
}
