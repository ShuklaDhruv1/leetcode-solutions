public class ImplementTrie {

    static class TrieNode {

        TrieNode[] children = new TrieNode[26];

        boolean isEndOfWord;
    }

    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode current = root;

        for (char c : word.toCharArray()) {

            int index = c - 'a';

            if (current.children[index] == null) {
                current.children[index] =
                        new TrieNode();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {

        TrieNode node = findNode(word);

        return node != null &&
               node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {

        return findNode(prefix) != null;
    }

    private TrieNode findNode(String word) {

        TrieNode current = root;

        for (char c : word.toCharArray()) {

            int index = c - 'a';

            if (current.children[index] == null) {
                return null;
            }

            current = current.children[index];
        }

        return current;
    }

    public static void main(String[] args) {

        ImplementTrie trie =
                new ImplementTrie();

        trie.insert("apple");

        System.out.println(
                "Search apple: " +
                trie.search("apple")
        );

        System.out.println(
                "Search app: " +
                trie.search("app")
        );

        System.out.println(
                "Starts with app: " +
                trie.startsWith("app")
        );

        trie.insert("app");

        System.out.println(
                "Search app after insert: " +
                trie.search("app")
        );
    }
}
