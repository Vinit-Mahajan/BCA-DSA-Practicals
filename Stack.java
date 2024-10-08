class Stack {
    static final int MAX = 4;
    int top;
    int a[] = new int[MAX];

    Stack(){
        top = -1;
    }

    void push(int x){
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return;
        }
        else {
			top++;
            a[top] = x;
            System.out.println(x + " pushed into stack");
        }
    }

    void pop(){
        if (top < 0) {
            System.out.println("Stack Underflow");
            return;
        }
        else {
            int x = a[top];
            top--;
            System.out.println(x + " Popped from stack");
        }
    }

    int peek(){
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int x = a[top];
            return x;
        }
    }

    void print(){
    for(int i = top;i>-1;i--){
      System.out.print(" "+ a[i]);
    }
  }
}

class Main {
    public static void main(String args[])
    {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
		s.push(40);

		s.pop();
		s.pop();



        System.out.println("Top element is :" + s.peek());
        System.out.print("Elements present in stack :");
        s.print();
    }
}


