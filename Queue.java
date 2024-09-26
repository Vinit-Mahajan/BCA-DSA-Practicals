import java.util.Scanner;
class IntQueue {
    private int size;
    private int front;
    private int rear;
    private int Q[];

    public IntQueue(int size) {
        this.size = size;
        front = rear = -1;
        Q = new int[size];
    }

    public void enqueue(int x) {
        if (rear == size - 1) {
            System.out.println("Queue is Full");
        } else {
            if (front == -1){
				front = 0;
			}
			rear++;
            Q[rear] = x;
            System.out.println("Inserted " + x);
        }
    }

    public int dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is Empty");
            return '\0';
        } else {
            int x = Q[front++];
            if (front > rear) {
                front = rear = -1; // Reset the queue after all elements are dequeued
            }
            System.out.println("Deleted " + x);
            return x;
        }
    }

    public void display() {
        if (front == -1) {
            System.out.println("Queue is Empty");
        } else {
            System.out.print("Queue Elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(Q[i] + " ");
            }
            System.out.println();
        }
    }
}
class Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum size of the queue: ");
        int maxSize = scanner.nextInt();
        IntQueue queue = new IntQueue(maxSize);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert an Element to Queue");
            System.out.println("2. Delete an Element from Queue");
            System.out.println("3. Display the Elements of Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a element to insert: ");
                    int elem = scanner.nextInt();
                    queue.enqueue(elem);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }
}
