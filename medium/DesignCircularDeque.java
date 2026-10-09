public class DesignCircularDeque {

    private int[] deque;
    private int front;
    private int size;
    private int capacity;

    public DesignCircularDeque(int k) {
        deque = new int[k];
        capacity = k;
        front = 0;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        size++;

        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        int rear = (front + size) % capacity;
        deque[rear] = value;
        size++;

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        size--;

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        size--;

        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return deque[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        int rear = (front + size - 1) % capacity;
        return deque[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {

        DesignCircularDeque deque =
                new DesignCircularDeque(3);

        System.out.println(deque.insertLast(10));
        System.out.println(deque.insertLast(20));
        System.out.println(deque.insertFront(30));
        System.out.println(deque.insertFront(40));

        System.out.println("Front: " + deque.getFront());
        System.out.println("Rear: " + deque.getRear());

        System.out.println("Delete Last: " + deque.deleteLast());

        System.out.println(deque.insertFront(40));

        System.out.println("Front: " + deque.getFront());
        System.out.println("Rear: " + deque.getRear());
    }
}
