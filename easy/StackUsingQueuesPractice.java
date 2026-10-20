
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueuesPractice {

    private Queue<Integer> queue;

    public StackUsingQueuesPractice() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);

        // Naye element ko queue ke front par lao
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        if (queue.isEmpty()) {
            return -1;
        }

        return queue.poll();
    }

    public int top() {
        if (queue.isEmpty()) {
            return -1;
        }

        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueuesPractice stack =
                new StackUsingQueuesPractice();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Empty: " + stack.empty());

        System.out.println("Pop: " + stack.pop());
        System.out.println("Empty: " + stack.empty());
    }
}
