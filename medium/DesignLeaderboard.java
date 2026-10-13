
import java.util.*;

public class DesignLeaderboard {

    private Map<Integer, Integer> scores;

    public DesignLeaderboard() {
        scores = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        scores.put(
            playerId,
            scores.getOrDefault(playerId, 0) + score
        );
    }

    public int top(int K) {
        List<Integer> allScores =
            new ArrayList<>(scores.values());

        allScores.sort(Collections.reverseOrder());

        int total = 0;

        for (int i = 0; i < K && i < allScores.size(); i++) {
            total += allScores.get(i);
        }

        return total;
    }

    public void reset(int playerId) {
        scores.remove(playerId);
    }

    public static void main(String[] args) {

        DesignLeaderboard leaderboard =
            new DesignLeaderboard();

        leaderboard.addScore(1, 73);
        leaderboard.addScore(2, 56);
        leaderboard.addScore(3, 39);
        leaderboard.addScore(4, 51);
        leaderboard.addScore(5, 4);

        System.out.println("Top 1: " + leaderboard.top(1));
        System.out.println("Top 3: " + leaderboard.top(3));

        leaderboard.reset(1);

        System.out.println(
            "Top 3 after reset: " + leaderboard.top(3)
        );
    }
}
