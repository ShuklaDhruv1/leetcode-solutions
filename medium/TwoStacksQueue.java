
import java.util.Stack;

public class TwoStacksQueue {

    private Stack<Integer> input;
    private Stack<Integer> output;

    public TwoStacksQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        moveElements();

        if (output.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return output.pop();
    }

    public int peek() {
        moveElements();

        if (output.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    private void moveElements() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }

    public static void main(String[] args) {
        TwoStacksQueue queue = new TwoStacksQueue();

        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Front: " + queue.peek());
        System.out.println("Removed: " + queue.pop());
        System.out.println("Removed: " + queue.pop());

        queue.push(40);

        System.out.println("Front: " + queue.peek());
        System.out.println("Is empty: " + queue.empty());
    }
}
