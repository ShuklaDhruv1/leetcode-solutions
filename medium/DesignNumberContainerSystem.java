
import java.util.*;

public class DesignNumberContainerSystem {

    private Map<Integer, Integer> indexToNumber;
    private Map<Integer, TreeSet<Integer>> numberToIndexes;

    public DesignNumberContainerSystem() {
        indexToNumber = new HashMap<>();
        numberToIndexes = new HashMap<>();
    }

    public void change(int index, int number) {

        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);

            numberToIndexes.get(oldNumber).remove(index);

            if (numberToIndexes.get(oldNumber).isEmpty()) {
                numberToIndexes.remove(oldNumber);
            }
        }

        indexToNumber.put(index, number);

        numberToIndexes.putIfAbsent(number, new TreeSet<>());
        numberToIndexes.get(number).add(index);
    }

    public int find(int number) {

        if (!numberToIndexes.containsKey(number)) {
            return -1;
        }

        return numberToIndexes.get(number).first();
    }

    public static void main(String[] args) {

        DesignNumberContainerSystem system =
            new DesignNumberContainerSystem();

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
