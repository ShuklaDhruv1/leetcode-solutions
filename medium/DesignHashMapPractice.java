
public class DesignHashMapPractice {

    private static final int SIZE = 1000;

    private int[][] buckets;

    public DesignHashMapPractice() {
        buckets = new int[SIZE][];
    }

    public void put(int key, int value) {
        int index = key % SIZE;

        if (buckets[index] == null) {
            buckets[index] = new int[2];
            buckets[index][0] = key;
            buckets[index][1] = value;
            return;
        }

        int[] bucket = buckets[index];

        if (bucket[0] == key) {
            bucket[1] = value;
        } else {
            // Simple collision handling for this example
            int[] newBucket = new int[bucket.length + 2];
            System.arraycopy(bucket, 0, newBucket, 0, bucket.length);
            newBucket[bucket.length] = key;
            newBucket[bucket.length + 1] = value;
            buckets[index] = newBucket;
        }
    }

    public int get(int key) {
        int index = key % SIZE;

        if (buckets[index] == null) {
            return -1;
        }

        int[] bucket = buckets[index];

        for (int i = 0; i < bucket.length; i += 2) {
            if (bucket[i] == key) {
                return bucket[i + 1];
            }
        }

        return -1;
    }

    public void remove(int key) {
        int index = key % SIZE;

        if (buckets[index] == null) {
            return;
        }

        int[] bucket = buckets[index];

        for (int i = 0; i < bucket.length; i += 2) {
            if (bucket[i] == key) {
                int[] newBucket = new int[bucket.length - 2];

                System.arraycopy(bucket, 0, newBucket, 0, i);
                System.arraycopy(
                    bucket, i + 2,
                    newBucket, i,
                    bucket.length - i - 2
                );

                buckets[index] =
                    newBucket.length == 0 ? null : newBucket;
                return;
            }
        }
    }

    public static void main(String[] args) {
        DesignHashMapPractice map = new DesignHashMapPractice();

        map.put(1, 100);
        map.put(2, 200);

        System.out.println(map.get(1));
        System.out.println(map.get(3));

        map.put(2, 250);
        System.out.println(map.get(2));

        map.remove(2);
        System.out.println(map.get(2));
    }
}
