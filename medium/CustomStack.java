
public class CustomStack {

    private int[] stack;
    private int top;
    private int capacity;

    public CustomStack(int maxSize) {
        capacity = maxSize;
        stack = new int[maxSize];
        top = -1;
    }

    public void push(int x) {
        if (top == capacity - 1) {
            return;
        }

        stack[++top] = x;
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }

        return stack[top--];
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, top + 1);

        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);

        stack.push(1);
        stack.push(2);

        stack.increment(2, 100);

        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
