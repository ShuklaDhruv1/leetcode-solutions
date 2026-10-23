
public class CountSquareSubmatricesPractice {

    public static int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        int total = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (matrix[r][c] == 1) {

                    if (r == 0 || c == 0) {
                        dp[r][c] = 1;
                    } else {
                        dp[r][c] = 1 + Math.min(
                            dp[r - 1][c - 1],
                            Math.min(
                                dp[r - 1][c],
                                dp[r][c - 1]
                            )
                        );
                    }

                    total += dp[r][c];
                }
            }
        }

        return total;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
        };

        System.out.println(countSquares(matrix));
    }
}
