import java.util.Scanner;
public class ArrayOperations {

    public static void displayArray(int[] arr, int size) {
        System.out.print("Array elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Function to insert an element at a given position
    public static int insertElement(int[] arr, int size, int elem, int pos) {
        if (pos < 0 || pos > size) {
            System.out.println("Invalid position! Please enter position between 0 and " + size);
            return size;
        }
        for (int i = size; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = elem;
        size++;
        return size;
    }

    // Function to delete an element at a given position
    public static int deleteElement(int[] arr, int size, int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid position! Please enter position between 0 and " + (size - 1));
            return size;
        }
        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int array[] = new int[n + 10];  // extra space for insert operations
        int size = n;

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display Array Elements");
            System.out.println("2. Insert an Element");
            System.out.println("3. Delete an Element");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayArray(array, size);
                    break;
                case 2:
                    System.out.print("Enter the element to insert: ");
                    int elem = scanner.nextInt();
                    System.out.print("Enter the position to insert the element: ");
                    int posInsert = scanner.nextInt();
                    size = insertElement(array, size, elem, posInsert);
                    break;
                case 3:
                    System.out.print("Enter the position to delete the element: ");
                    int posDelete = scanner.nextInt();
                    size = deleteElement(array, size, posDelete);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
