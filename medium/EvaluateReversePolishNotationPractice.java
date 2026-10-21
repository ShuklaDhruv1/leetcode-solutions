
import java.util.Stack;

public class EvaluateReversePolishNotationPractice {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+")
                    || token.equals("-")
                    || token.equals("*")
                    || token.equals("/")) {

                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;

                    case "-":
                        stack.push(a - b);
                        break;

                    case "*":
                        stack.push(a * b);
                        break;

                    case "/":
                        stack.push(a / b);
                        break;
                }

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] expression1 = {"2", "1", "+", "3", "*"};
        String[] expression2 = {"4", "13", "5", "/", "+"};
        String[] expression3 = {"10", "6", "9", "3", "+", "-11",
                                "*", "/", "*", "17", "+", "5", "+"};

        System.out.println(evalRPN(expression1));
        System.out.println(evalRPN(expression2));
        System.out.println(evalRPN(expression3));
    }
}
