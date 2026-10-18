
import java.util.*;

public class PhoneDirectoryPractice {

    private Queue<Integer> available;
    private Set<Integer> assigned;
    private int maxNumbers;

    public PhoneDirectoryPractice(int maxNumbers) {
        this.maxNumbers = maxNumbers;
        available = new LinkedList<>();
        assigned = new HashSet<>();

        for (int i = 0; i < maxNumbers; i++) {
            available.offer(i);
        }
    }

    public int get() {
        if (available.isEmpty()) {
            return -1;
        }

        int number = available.poll();
        assigned.add(number);
        return number;
    }

    public boolean check(int number) {
        return number >= 0
                && number < maxNumbers
                && !assigned.contains(number);
    }

    public void release(int number) {
        if (assigned.remove(number)) {
            available.offer(number);
        }
    }

    public static void main(String[] args) {
        PhoneDirectoryPractice directory =
                new PhoneDirectoryPractice(3);

        System.out.println(directory.get());
        System.out.println(directory.get());
        System.out.println(directory.check(2));
        System.out.println(directory.get());
        System.out.println(directory.get());

        directory.release(1);

        System.out.println(directory.check(1));
        System.out.println(directory.get());
    }
}
