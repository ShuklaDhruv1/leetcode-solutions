import java.util.*;

public class WordSearchII {

    static class TrieNode {

        TrieNode[] children =
                new TrieNode[26];

        String word;
    }

    public static List<String> findWords(
            char[][] board,
            String[] words) {

        List<String> result =
                new ArrayList<>();

        TrieNode root = new TrieNode();

        // Build Trie
        for (String word : words) {
            insert(root, word);
        }

        for (int row = 0;
             row < board.length;
             row++) {

            for (int col = 0;
                 col < board[0].length;
                 col++) {

                dfs(
                        board,
                        row,
                        col,
                        root,
                        result
                );
            }
        }

        return result;
    }

    public static void insert(
            TrieNode root,
            String word) {

        TrieNode current = root;

        for (char c : word.toCharArray()) {

            int index = c - 'a';

            if (current.children[index] == null) {
                current.children[index] =
                        new TrieNode();
            }

            current = current.children[index];
        }

        current.word = word;
    }

    public static void dfs(
            char[][] board,
            int row,
            int col,
            TrieNode node,
            List<String> result) {

        if (row < 0 ||
            row >= board.length ||
            col < 0 ||
            col >= board[0].length) {
            return;
        }

        char c = board[row][col];

        if (c == '#') {
            return;
        }

        TrieNode next =
                node.children[c - 'a'];

        if (next == null) {
            return;
        }

        if (next.word != null) {

            result.add(next.word);

            // Prevent duplicate result
            next.word = null;
        }

        board[row][col] = '#';

        dfs(board, row + 1, col, next, result);
        dfs(board, row - 1, col, next, result);
        dfs(board, row, col + 1, next, result);
        dfs(board, row, col - 1, next, result);

        board[row][col] = c;
    }

    public static void main(String[] args) {

        char[][] board = {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };

        String[] words = {
            "oath",
            "pea",
            "eat",
            "rain"
        };

        List<String> result =
                findWords(board, words);

        System.out.println(
                "Words Found: " + result
        );
    }
}
