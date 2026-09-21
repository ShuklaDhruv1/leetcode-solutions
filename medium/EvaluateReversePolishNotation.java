import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/")) {

                int second = stack.pop();
                int first = stack.pop();

                int result = 0;

                if (token.equals("+")) {
                    result = first + second;
                } else if (token.equals("-")) {
                    result = first - second;
                } else if (token.equals("*")) {
                    result = first * second;
                } else {
                    result = first / second;
                }

                stack.push(result);

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        String[] tokens = {"2", "1", "+", "3", "*"};

        int result = evalRPN(tokens);

        System.out.println("Result: " + result);
    }
}
