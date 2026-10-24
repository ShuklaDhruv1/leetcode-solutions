public class MinimumPathSumPractice {

    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        dp[0][0] = grid[0][0];

        // First row: move only right
        for (int c = 1; c < cols; c++) {
            dp[0][c] = dp[0][c - 1] + grid[0][c];
        }

        // First column: move only down
        for (int r = 1; r < rows; r++) {
            dp[r][0] = dp[r - 1][0] + grid[r][0];
        }

        // Calculate minimum sum for remaining cells
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                dp[r][c] = grid[r][c] + Math.min(
                    dp[r - 1][c],
                    dp[r][c - 1]
                );
            }
        }

        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        System.out.println(minPathSum(grid));
    }
}
