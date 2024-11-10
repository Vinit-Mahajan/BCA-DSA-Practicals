import java.util.Scanner;
class Stack {
    private int top;
    private int capacity;
    private String[] array;

    public Stack(int capacity) {
        this.capacity = capacity;
        array = new String[capacity];
        top = -1;
    }
    public void push(String item) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        array[++top] = item;
    }
    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return "";
        }
        return array[top--];
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == capacity - 1;
    }
}

class PrefixToPostfix {
    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    static String prefixToPostfix(String prefix) {
        Stack stack = new Stack(prefix.length());

        // Read the prefix expression from right to left
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            // If character is an operator, pop two operands from stack,
            // combine them in postfix form, and push the result back to stack
            if (isOperator(c)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = op1 + op2 + c;
                stack.push(temp);
            }
            // If character is an operand, push it to the stack
            else {
                stack.push(c + "");
            }
        }

        // The only element left in the stack is the postfix expression
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a prefix expression: ");
        String prefixExpression = scanner.nextLine();
        String postfixExpression = prefixToPostfix(prefixExpression);
        System.out.println("Postfix expression: " + postfixExpression);
        scanner.close();
    }
}
