public class ClimbingStairs {

    public static int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int oneStepBefore = 2;
        int twoStepsBefore = 1;

        for (int i = 3; i <= n; i++) {

            int current = oneStepBefore + twoStepsBefore;

            twoStepsBefore = oneStepBefore;
            oneStepBefore = current;
        }

        return oneStepBefore;
    }

    public static void main(String[] args) {

        int n = 5;

        int result = climbStairs(n);

        System.out.println("Ways to climb " + n + " stairs: " + result);
    }
}
