public class UniquePathsIIPractice {

    public static int uniquePathsWithObstacles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        // Starting cell par obstacle hai
        if (grid[0][0] == 1) {
            return 0;
        }

        dp[0][0] = 1;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                // Obstacle wale cell tak koi path nahi
                if (grid[r][c] == 1) {
                    dp[r][c] = 0;
                    continue;
                }

                // Starting cell already initialized
                if (r == 0 && c == 0) {
                    continue;
                }

                // Top se aane wale paths
                if (r > 0) {
                    dp[r][c] += dp[r - 1][c];
                }

                // Left se aane wale paths
                if (c > 0) {
                    dp[r][c] += dp[r][c - 1];
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        System.out.println(uniquePathsWithObstacles(grid));
    }
}
