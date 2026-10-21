
import java.util.Stack;

public class MinStackPractice {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStackPractice() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        int removed = stack.pop();

        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }

        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }

        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStackPractice stack = new MinStackPractice();

        stack.push(5);
        stack.push(2);
        stack.push(8);
        stack.push(2);

        System.out.println("Top: " + stack.top());
        System.out.println("Minimum: " + stack.getMin());

        stack.pop();

        System.out.println("Top after pop: " + stack.top());
        System.out.println("Minimum after pop: " + stack.getMin());

        stack.pop();

        System.out.println("Minimum after second pop: " + stack.getMin());
    }
}
