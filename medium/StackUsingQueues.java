
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    private Queue<Integer> queue;

    public StackUsingQueues() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);

        // Naye element ko front par lao
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return queue.poll();
    }

    public int top() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.top());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        stack.push(40);

        System.out.println("Top: " + stack.top());
        System.out.println("Is empty: " + stack.empty());
    }
}
