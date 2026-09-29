import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public FindMedianFromDataStream() {

        // Left half
        maxHeap = new PriorityQueue<>(
                (a, b) -> b - a
        );

        // Right half
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Balance the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {

        FindMedianFromDataStream median =
                new FindMedianFromDataStream();

        median.addNum(1);
        median.addNum(2);

        System.out.println(
                "Median: " + median.findMedian()
        );

        median.addNum(3);

        System.out.println(
                "Median: " + median.findMedian()
        );
    }
}
