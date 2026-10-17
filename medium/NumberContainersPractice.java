
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class NumberContainersPractice {

    private Map<Integer, Integer> indexToNumber;
    private Map<Integer, TreeSet<Integer>> numberToIndexes;

    public NumberContainersPractice() {
        indexToNumber = new HashMap<>();
        numberToIndexes = new HashMap<>();
    }

    public void change(int index, int number) {

        // Agar index par pehle se number hai, use remove karo
        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);

            TreeSet<Integer> oldIndexes =
                    numberToIndexes.get(oldNumber);

            oldIndexes.remove(index);

            if (oldIndexes.isEmpty()) {
                numberToIndexes.remove(oldNumber);
            }
        }

        // Naya number assign karo
        indexToNumber.put(index, number);

        numberToIndexes
                .computeIfAbsent(number, key -> new TreeSet<>())
                .add(index);
    }

    public int find(int number) {
        TreeSet<Integer> indexes = numberToIndexes.get(number);

        if (indexes == null || indexes.isEmpty()) {
            return -1;
        }

        return indexes.first();
    }

    public static void main(String[] args) {
        NumberContainersPractice system =
                new NumberContainersPractice();

        system.change(2, 10);
        system.change(1, 10);
        system.change(3, 20);

        System.out.println(system.find(10));
        System.out.println(system.find(20));
        System.out.println(system.find(30));

        system.change(1, 20);

        System.out.println(system.find(10));
        System.out.println(system.find(20));
    }
}
