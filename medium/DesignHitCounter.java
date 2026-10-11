
import java.util.LinkedList;
import java.util.Queue;

public class DesignHitCounter {

    private Queue<Integer> hits;

    public DesignHitCounter() {
        hits = new LinkedList<>();
    }

    public void hit(int timestamp) {
        hits.offer(timestamp);
    }

    public int getHits(int timestamp) {

        while (!hits.isEmpty()
                && timestamp - hits.peek() >= 300) {
            hits.poll();
        }

        return hits.size();
    }

    public static void main(String[] args) {

        DesignHitCounter counter = new DesignHitCounter();

        counter.hit(1);
        counter.hit(2);
        counter.hit(3);

        System.out.println(counter.getHits(4));
        System.out.println(counter.getHits(300));

        counter.hit(300);

        System.out.println(counter.getHits(300));
        System.out.println(counter.getHits(301));
        System.out.println(counter.getHits(600));
    }
}
