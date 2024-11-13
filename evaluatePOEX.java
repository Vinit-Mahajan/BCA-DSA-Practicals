public class PostfixEvaluator {
    // Method to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
        int[] stack = new int[expression.length()];
        int top = -1;

        // Traverse each character in the expressionx
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If the character is a digit, push it onto the stack
            if (Character.isDigit(ch)) {
                stack[++top] = ch - '0'; // Convert char to int by subtracting '0'
            }
            // If the character is an operator, pop two elements and apply the operator
            else {
                int operand2 = stack[top--];
                int operand1 = stack[top--];

                switch (ch) {
                    case '+':
                        stack[++top] = operand1 + operand2;
                        break;
                    case '-':
                        stack[++top] = operand1 - operand2;
                        break;
                    case '*':
                        stack[++top] = operand1 * operand2;
                        break;
                    case '/':
                        stack[++top] = operand1 / operand2;
                        break;
                }
            }
        }
        // The result is the only element left in the stack
        return stack[top];
    }

    public static void main(String[] args) {
        String expression = "231*+9-"; // Example postfix expression
        int result = evaluatePostfix(expression);
        System.out.println("The result of the postfix expression is: " + result);
    }
}
