
public class MyCircularDequePractice {

    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyCircularDequePractice(int k) {
        capacity = k;
        deque = new int[k];
        front = 0;
        rear = k - 1;
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

        rear = (rear + 1) % capacity;
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

        rear = (rear - 1 + capacity) % capacity;
        size--;

        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : deque[front];
    }

    public int getRear() {
        return isEmpty() ? -1 : deque[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        MyCircularDequePractice deque =
                new MyCircularDequePractice(3);

        System.out.println(deque.insertLast(10));
        System.out.println(deque.insertLast(20));
        System.out.println(deque.insertFront(30));
        System.out.println(deque.insertFront(40));

        System.out.println("Front: " + deque.getFront());
        System.out.println("Rear: " + deque.getRear());

        System.out.println(deque.deleteLast());
        System.out.println(deque.insertFront(40));

        System.out.println("Front: " + deque.getFront());
        System.out.println("Rear: " + deque.getRear());
        System.out.println("Full: " + deque.isFull());
    }
}
