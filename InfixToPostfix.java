import java.util.Scanner;
class Stack {
    private int top;
    private int capacity;
    private char[] array;

    public Stack(int capacity) {
        this.capacity = capacity;
        array = new char[capacity];
        top = -1;
    }
    public void push(char item) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        array[++top] = item;
    }
    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return '\0';
        }
        return array[top--];
    }
    public char peek() {
        if (isEmpty()) {
            return '\0';
        }
        return array[top];
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == capacity - 1;
    }
}
class InfixToPostfix {
    static int precedence(char op) {
        if (op == '^')
            return 3;
        else if (op == '*' || op == '/')
            return 2;
        else if (op == '+' || op == '-')
            return 1;
        else
            return 0;
    }
    static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
    static String infixToPostfix(String infix) {
        String postfix = "";
        Stack stack = new Stack(infix.length());

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (isOperand(c)) {
                postfix += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    System.out.println("Invalid expression");
                    return "";
                } else {
                    stack.pop();
                }
            } else { // Operator
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }
        return postfix;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String infixExpression = scanner.nextLine();
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Postfix expression: " + postfixExpression);
        scanner.close();
    }
}
