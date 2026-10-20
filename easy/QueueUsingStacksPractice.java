
import java.util.Stack;

public class QueueUsingStacksPractice {

    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public QueueUsingStacksPractice() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        moveElements();

        if (outputStack.isEmpty()) {
            return -1;
        }

        return outputStack.pop();
    }

    public int peek() {
        moveElements();

        if (outputStack.isEmpty()) {
            return -1;
        }

        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    private void moveElements() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueUsingStacksPractice queue =
                new QueueUsingStacksPractice();

        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Front: " + queue.peek());
        System.out.println("Pop: " + queue.pop());
        System.out.println("Pop: " + queue.pop());

        queue.push(40);

        System.out.println("Front: " + queue.peek());
        System.out.println("Pop: " + queue.pop());
        System.out.println("Pop: " + queue.pop());
        System.out.println("Empty: " + queue.empty());
    }
}
