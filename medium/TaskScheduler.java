import java.util.PriorityQueue;

public class TaskScheduler {

    public static int leastInterval(
            char[] tasks,
            int n) {

        int[] frequency = new int[26];

        for (char task : tasks) {
            frequency[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> b - a);

        for (int count : frequency) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        int time = 0;

        while (!maxHeap.isEmpty()) {

            int cycle = n + 1;
            int used = 0;

            int[] waiting = new int[26];
            int waitingCount = 0;

            while (cycle > 0 && !maxHeap.isEmpty()) {

                int current = maxHeap.poll();

                current--;

                if (current > 0) {
                    waiting[waitingCount++] = current;
                }

                used++;
                cycle--;
                time++;
            }

            for (int i = 0; i < waitingCount; i++) {
                maxHeap.offer(waiting[i]);
            }

            if (maxHeap.isEmpty()) {
                break;
            }

            // Idle time
            time += cycle;
        }

        return time;
    }

    public static void main(String[] args) {

        char[] tasks = {
            'A', 'A', 'A',
            'B', 'B', 'B'
        };

        int n = 2;

        int result = leastInterval(tasks, n);

        System.out.println(
                "Minimum Intervals: " + result
        );
    }
}
