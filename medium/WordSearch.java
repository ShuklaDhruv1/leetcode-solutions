public class WordSearch {

    public static boolean exist(char[][] board, String word) {

        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[0].length; col++) {

                if (dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(
            char[][] board,
            String word,
            int row,
            int col,
            int index) {

        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            board[row][col] != word.charAt(index)) {

            return false;
        }

        char original = board[row][col];

        // Mark cell as visited
        board[row][col] = '#';

        boolean found =
                dfs(board, word, row + 1, col, index + 1) ||
                dfs(board, word, row - 1, col, index + 1) ||
                dfs(board, word, row, col + 1, index + 1) ||
                dfs(board, word, row, col - 1, index + 1);

        // Restore cell
        board[row][col] = original;

        return found;
    }

    public static void main(String[] args) {

        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";

        boolean result = exist(board, word);

        System.out.println("Word Found: " + result);
    }
}
