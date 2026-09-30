import java.util.*;

public class WordLadderII {

    public static List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        List<List<String>> result = new ArrayList<>();

        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return result;
        }

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {

            String current = queue.poll();

            int currentDistance = distance.get(current);

            char[] chars = current.toCharArray();

            for (int i = 0; i < chars.length; i++) {

                char original = chars[i];

                for (char c = 'a'; c <= 'z'; c++) {

                    if (c == original) {
                        continue;
                    }

                    chars[i] = c;

                    String nextWord = new String(chars);

                    if (!wordSet.contains(nextWord)) {
                        continue;
                    }

                    if (!distance.containsKey(nextWord)) {

                        distance.put(
                                nextWord,
                                currentDistance + 1
                        );

                        queue.offer(nextWord);

                        graph.putIfAbsent(
                                nextWord,
                                new ArrayList<>()
                        );
                    }

                    if (distance.get(nextWord)
                            == currentDistance + 1) {

                        graph.putIfAbsent(
                                current,
                                new ArrayList<>()
                        );

                        graph.get(current).add(nextWord);
                    }
                }

                chars[i] = original;
            }
        }

        if (!distance.containsKey(endWord)) {
            return result;
        }

        List<String> path = new ArrayList<>();
        path.add(beginWord);

        backtrack(
                beginWord,
                endWord,
                graph,
                path,
                result
        );

        return result;
    }

    public static void backtrack(
            String current,
            String endWord,
            Map<String, List<String>> graph,
            List<String> path,
            List<List<String>> result) {

        if (current.equals(endWord)) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (!graph.containsKey(current)) {
            return;
        }

        for (String next : graph.get(current)) {

            path.add(next);

            backtrack(
                    next,
                    endWord,
                    graph,
                    path,
                    result
            );

            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = Arrays.asList(
                "hot",
                "dot",
                "dog",
                "lot",
                "log",
                "cog"
        );

        List<List<String>> result =
                findLadders(
                        beginWord,
                        endWord,
                        wordList
                );

        System.out.println(
                "Shortest Transformation Sequences:"
        );

        for (List<String> path : result) {
            System.out.println(path);
        }
    }
}
