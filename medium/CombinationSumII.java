import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(
            int[] candidates,
            int target) {

        List<List<Integer>> result =
                new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(
                candidates,
                target,
                0,
                new ArrayList<>(),
                result
        );

        return result;
    }

    public static void backtrack(
            int[] candidates,
            int target,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start;
             i < candidates.length;
             i++) {

            // Skip duplicate choices
            if (i > start &&
                candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Since array is sorted
            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);

            // i + 1 means each number can be used once
            backtrack(
                    candidates,
                    target - candidates[i],
                    i + 1,
                    current,
                    result
            );

            current.remove(
                    current.size() - 1
            );
        }
    }

    public static void main(String[] args) {

        int[] candidates = {
            10, 1, 2, 7, 6, 1, 5
        };

        int target = 8;

        List<List<Integer>> result =
                combinationSum2(
                        candidates,
                        target
                );

        System.out.println(
                "Unique Combinations:"
        );

        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
