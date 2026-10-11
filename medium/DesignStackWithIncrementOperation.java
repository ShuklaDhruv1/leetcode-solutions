
public class DesignStackWithIncrementOperation {

    private int[] stack;
    private int top;
    private int maxSize;

    public DesignStackWithIncrementOperation(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
        top = -1;
    }

    public void push(int x) {
        if (top < maxSize - 1) {
            stack[++top] = x;
        }
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

        DesignStackWithIncrementOperation stk =
            new DesignStackWithIncrementOperation(3);

        stk.push(1);
        stk.push(2);

        stk.increment(2, 100);

        stk.push(3);
        stk.push(4);

        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
    }
}
