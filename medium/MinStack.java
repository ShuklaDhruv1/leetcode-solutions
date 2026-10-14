
import java.util.Stack;

public class MinStack {

    private Stack<Integer> values;
    private Stack<Integer> minimums;

    public MinStack() {
        values = new Stack<>();
        minimums = new Stack<>();
    }

    public void push(int val) {
        values.push(val);

        if (minimums.isEmpty() || val <= minimums.peek()) {
            minimums.push(val);
        }
    }

    public void pop() {
        int removed = values.pop();

        if (removed == minimums.peek()) {
            minimums.pop();
        }
    }

    public int top() {
        return values.peek();
    }

    public int getMin() {
        return minimums.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(2);

        System.out.println("Minimum: " + stack.getMin());
        System.out.println("Top: " + stack.top());

        stack.pop();

        System.out.println("Minimum after pop: " + stack.getMin());
        System.out.println("Top after pop: " + stack.top());
    }
}
