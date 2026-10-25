public class MinimumFallingPathSumPractice {

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // First row ko initialize karo
        for (int c = 0; c < n; c++) {
            dp[0][c] = matrix[0][c];
        }

        // Remaining rows calculate karo
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n; c++) {

                int above = dp[r - 1][c];

                int leftDiagonal = (c > 0)
                        ? dp[r - 1][c - 1]
                        : Integer.MAX_VALUE;

                int rightDiagonal = (c < n - 1)
                        ? dp[r - 1][c + 1]
                        : Integer.MAX_VALUE;

                dp[r][c] = matrix[r][c]
                        + Math.min(
                            above,
                            Math.min(leftDiagonal, rightDiagonal)
                        );
            }
        }

        // Last row ka minimum sum return karo
        int minSum = dp[n - 1][0];

        for (int c = 1; c < n; c++) {
            minSum = Math.min(minSum, dp[n - 1][c]);
        }

        return minSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };

        System.out.println(minFallingPathSum(matrix));
    }
}
