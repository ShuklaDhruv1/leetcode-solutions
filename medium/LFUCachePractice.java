
import java.util.*;

public class LFUCachePractice {
    private int capacity;
    private int minFrequency;

    private Map<Integer, Integer> values;
    private Map<Integer, Integer> frequencies;
    private Map<Integer, LinkedHashSet<Integer>> frequencyKeys;

    public LFUCachePractice(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;

        values = new HashMap<>();
        frequencies = new HashMap<>();
        frequencyKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }

        increaseFrequency(key);
        return values.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (values.containsKey(key)) {
            values.put(key, value);
            increaseFrequency(key);
            return;
        }

        if (values.size() == capacity) {
            LinkedHashSet<Integer> keys =
                frequencyKeys.get(minFrequency);

            int keyToRemove = keys.iterator().next();
            keys.remove(keyToRemove);

            values.remove(keyToRemove);
            frequencies.remove(keyToRemove);

            if (keys.isEmpty()) {
                frequencyKeys.remove(minFrequency);
            }
        }

        values.put(key, value);
        frequencies.put(key, 1);

        frequencyKeys
            .computeIfAbsent(1, k -> new LinkedHashSet<>())
            .add(key);

        minFrequency = 1;
    }

    private void increaseFrequency(int key) {
        int oldFrequency = frequencies.get(key);

        LinkedHashSet<Integer> oldKeys =
            frequencyKeys.get(oldFrequency);

        oldKeys.remove(key);

        if (oldKeys.isEmpty()) {
            frequencyKeys.remove(oldFrequency);

            if (minFrequency == oldFrequency) {
                minFrequency++;
            }
        }

        int newFrequency = oldFrequency + 1;
        frequencies.put(key, newFrequency);

        frequencyKeys
            .computeIfAbsent(
                newFrequency, k -> new LinkedHashSet<>()
            )
            .add(key);
    }

    public static void main(String[] args) {
        LFUCachePractice cache = new LFUCachePractice(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(1));

        cache.put(3, 30);

        System.out.println(cache.get(2));
        System.out.println(cache.get(3));

        cache.put(4, 40);

        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
