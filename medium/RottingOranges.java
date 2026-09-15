import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;
        int minutes = 0;

        for (int row = 0; row < grid.length; row++) {

            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();
            minutes++;

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                for (int[] direction : directions) {

                    int newRow = current[0] + direction[0];
                    int newCol = current[1] + direction[1];

                    if (newRow >= 0 && newRow < grid.length &&
                        newCol >= 0 && newCol < grid[0].length &&
                        grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        fresh--;

                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int result = orangesRotting(grid);

        System.out.println("Minutes Required: " + result);
    }
}
