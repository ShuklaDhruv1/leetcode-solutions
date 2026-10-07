public class DesignAddAndSearchWordsDataStructure {

    static class TrieNode {

        TrieNode[] children =
                new TrieNode[26];

        boolean isEndOfWord;
    }

    private TrieNode root;

    public DesignAddAndSearchWordsDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {

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

        return searchWord(
                root,
                word,
                0
        );
    }

    private boolean searchWord(
            TrieNode node,
            String word,
            int index) {

        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char c = word.charAt(index);

        if (c == '.') {

            for (TrieNode child : node.children) {

                if (child != null &&
                    searchWord(
                            child,
                            word,
                            index + 1)) {

                    return true;
                }
            }

            return false;
        }

        int childIndex = c - 'a';

        if (node.children[childIndex] == null) {
            return false;
        }

        return searchWord(
                node.children[childIndex],
                word,
                index + 1
        );
    }

    public static void main(String[] args) {

        DesignAddAndSearchWordsDataStructure
                dictionary =
                new DesignAddAndSearchWordsDataStructure();

        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");

        System.out.println(
                "Search bad: " +
                dictionary.search("bad")
        );

        System.out.println(
                "Search pad: " +
                dictionary.search("pad")
        );

        System.out.println(
                "Search .ad: " +
                dictionary.search(".ad")
        );

        System.out.println(
                "Search b..: " +
                dictionary.search("b..")
        );
    }
}
