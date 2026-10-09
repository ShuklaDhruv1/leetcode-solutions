public class DesignCircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public DesignCircularQueue(int k) {

        capacity = k;
        queue = new int[k];

        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;

        return true;
    }

    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        size--;

        return true;
    }

    public int Front() {

        if (isEmpty()) {
            return -1;
        }

        return queue[front];
    }

    public int Rear() {

        if (isEmpty()) {
            return -1;
        }

        return queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {

        DesignCircularQueue q =
                new DesignCircularQueue(3);

        System.out.println(q.enQueue(10));
        System.out.println(q.enQueue(20));
        System.out.println(q.enQueue(30));
        System.out.println(q.enQueue(40));

        System.out.println("Front: " + q.Front());
        System.out.println("Rear: " + q.Rear());

        System.out.println("Dequeue: " + q.deQueue());

        System.out.println(q.enQueue(40));

        System.out.println("Front: " + q.Front());
        System.out.println("Rear: " + q.Rear());
    }
}
