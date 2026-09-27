import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {

    static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<Pair>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(
            String key,
            String value,
            int timestamp) {

        map.putIfAbsent(key, new ArrayList<>());

        map.get(key).add(
                new Pair(timestamp, value)
        );
    }

    public String get(
            String key,
            int timestamp) {

        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;

        String answer = "";

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp <= timestamp) {

                answer = list.get(mid).value;
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        TimeBasedKeyValueStore store =
                new TimeBasedKeyValueStore();

        store.set("foo", "bar", 1);

        System.out.println(
                store.get("foo", 1)
        );

        System.out.println(
                store.get("foo", 3)
        );

        store.set("foo", "bar2", 4);

        System.out.println(
                store.get("foo", 4)
        );

        System.out.println(
                store.get("foo", 5)
        );
    }
}
