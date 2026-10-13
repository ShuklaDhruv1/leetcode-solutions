
import java.util.*;

public class RandomizedSet {

    private List<Integer> numbers;
    private Map<Integer, Integer> positions;
    private Random random;

    public RandomizedSet() {
        numbers = new ArrayList<>();
        positions = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (positions.containsKey(val)) {
            return false;
        }

        positions.put(val, numbers.size());
        numbers.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!positions.containsKey(val)) {
            return false;
        }

        int index = positions.get(val);
        int lastValue = numbers.get(numbers.size() - 1);

        numbers.set(index, lastValue);
        positions.put(lastValue, index);

        numbers.remove(numbers.size() - 1);
        positions.remove(val);

        return true;
    }

    public int getRandom() {
        int index = random.nextInt(numbers.size());
        return numbers.get(index);
    }

    public static void main(String[] args) {

        RandomizedSet set = new RandomizedSet();

        System.out.println(set.insert(10));
        System.out.println(set.insert(20));
        System.out.println(set.insert(10));

        System.out.println(set.remove(10));

        System.out.println(set.insert(30));

        System.out.println("Random value: " + set.getRandom());
    }
}
