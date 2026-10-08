import java.util.*;

public class AllOoneDataStructure {

    static class Bucket {

        int count;
        Set<String> keys;

        Bucket prev;
        Bucket next;

        Bucket(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Bucket head;
    private Bucket tail;

    private Map<String, Bucket> keyMap;

    public AllOoneDataStructure() {

        head = new Bucket(0);
        tail = new Bucket(0);

        head.next = tail;
        tail.prev = head;

        keyMap = new HashMap<>();
    }

    public void inc(String key) {

        if (!keyMap.containsKey(key)) {

            Bucket first = head.next;

            if (first == tail || first.count != 1) {

                Bucket newBucket =
                        new Bucket(1);

                insertAfter(head, newBucket);

                first = newBucket;
            }

            first.keys.add(key);

            keyMap.put(key, first);

        } else {

            Bucket current =
                    keyMap.get(key);

            Bucket next = current.next;

            if (next == tail ||
                next.count != current.count + 1) {

                Bucket newBucket =
                        new Bucket(
                                current.count + 1
                        );

                insertAfter(
                        current,
                        newBucket
                );

                next = newBucket;
            }

            next.keys.add(key);

            keyMap.put(key, next);

            current.keys.remove(key);

            removeIfEmpty(current);
        }
    }

    public void dec(String key) {

        if (!keyMap.containsKey(key)) {
            return;
        }

        Bucket current =
                keyMap.get(key);

        if (current.count == 1) {

            current.keys.remove(key);

            keyMap.remove(key);

            removeIfEmpty(current);

            return;
        }

        Bucket previous =
                current.prev;

        if (previous == head ||
            previous.count != current.count - 1) {

            Bucket newBucket =
                    new Bucket(
                            current.count - 1
                    );

            insertAfter(
                    current.prev,
                    newBucket
            );

            previous = newBucket;
        }

        previous.keys.add(key);

        keyMap.put(key, previous);

        current.keys.remove(key);

        removeIfEmpty(current);
    }

    public String getMaxKey() {

        if (tail.prev == head) {
            return "";
        }

        return tail.prev.keys
                .iterator()
                .next();
    }

    public String getMinKey() {

        if (head.next == tail) {
            return "";
        }

        return head.next.keys
                .iterator()
                .next();
    }

    private void insertAfter(
            Bucket previous,
            Bucket bucket) {

        bucket.next = previous.next;
        bucket.prev = previous;

        previous.next.prev = bucket;
        previous.next = bucket;
    }

    private void removeIfEmpty(
            Bucket bucket) {

        if (bucket.keys.isEmpty()) {

            bucket.prev.next = bucket.next;
            bucket.next.prev = bucket.prev;
        }
    }

    public static void main(String[] args) {

        AllOoneDataStructure ds =
                new AllOoneDataStructure();

        ds.inc("hello");
        ds.inc("hello");
        ds.inc("world");

        System.out.println(
                "Max Key: " +
                ds.getMaxKey()
        );

        System.out.println(
                "Min Key: " +
                ds.getMinKey()
        );

        ds.dec("hello");

        System.out.println(
                "Max Key After Decrease: " +
                ds.getMaxKey()
        );

        ds.dec("hello");

        System.out.println(
                "Min Key After Removing hello: " +
                ds.getMinKey()
        );
    }
}
