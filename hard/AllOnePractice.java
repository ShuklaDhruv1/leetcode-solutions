
import java.util.*;

public class AllOnePractice {

    private Map<String, Integer> counts;

    public AllOnePractice() {
        counts = new HashMap<>();
    }

    public void inc(String key) {
        counts.put(key, counts.getOrDefault(key, 0) + 1);
    }

    public void dec(String key) {
        if (!counts.containsKey(key)) {
            return;
        }

        int count = counts.get(key);

        if (count == 1) {
            counts.remove(key);
        } else {
            counts.put(key, count - 1);
        }
    }

    public String getMaxKey() {
        String result = "";
        int max = 0;

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }

    public String getMinKey() {
        String result = "";
        int min = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        AllOnePractice allOne = new AllOnePractice();

        allOne.inc("apple");
        allOne.inc("apple");
        allOne.inc("banana");
        allOne.inc("banana");
        allOne.inc("banana");

        System.out.println("Max key: " + allOne.getMaxKey());
        System.out.println("Min key: " + allOne.getMinKey());

        allOne.dec("banana");

        System.out.println("Max key: " + allOne.getMaxKey());
        System.out.println("Min key: " + allOne.getMinKey());
    }
}
