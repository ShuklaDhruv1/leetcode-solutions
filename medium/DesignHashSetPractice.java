
import java.util.LinkedList;

public class DesignHashSetPractice {

    private static final int SIZE = 1000;

    private LinkedList<Integer>[] buckets;

    @SuppressWarnings("unchecked")
    public DesignHashSetPractice() {
        buckets = new LinkedList[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int index = hash(key);

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }

    public void remove(int key) {
        int index = hash(key);

        if (buckets[index] != null) {
            buckets[index].remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        int index = hash(key);

        return buckets[index] != null
                && buckets[index].contains(key);
    }

    public static void main(String[] args) {
        DesignHashSetPractice set =
                new DesignHashSetPractice();

        set.add(10);
        set.add(20);
        set.add(10);

        System.out.println(set.contains(10));
        System.out.println(set.contains(30));

        set.remove(10);

        System.out.println(set.contains(10));
        System.out.println(set.contains(20));
    }
}
