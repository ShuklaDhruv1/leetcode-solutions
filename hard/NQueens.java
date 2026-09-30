import java.util.*;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(board, 0, result);

        return result;
    }

    public static void backtrack(
            char[][] board,
            int row,
            List<List<String>> result) {

        if (row == board.length) {

            List<String> solution = new ArrayList<>();

            for (char[] line : board) {
                solution.add(new String(line));
            }

            result.add(solution);
            return;
        }

        for (int col = 0; col < board.length; col++) {

            if (!isSafe(board, row, col)) {
                continue;
            }

            board[row][col] = 'Q';

            backtrack(board, row + 1, result);

            board[row][col] = '.';
        }
    }

    public static boolean isSafe(
            char[][] board,
            int row,
            int col) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int n = 4;

        List<List<String>> result =
                solveNQueens(n);

        System.out.println(
                "Number of Solutions: " + result.size()
        );

        for (List<String> solution : result) {

            for (String row : solution) {
                System.out.println(row);
            }

            System.out.println();
        }
    }
}
