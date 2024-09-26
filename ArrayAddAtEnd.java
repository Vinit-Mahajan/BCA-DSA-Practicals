import java.util.*;
class ArrayAddAtEnd {
    static int insertSorted(int arr[], int n, int key,int capacity){

        if (n >= capacity)
            return n;

        arr[n] = key;

        return (n + 1);
    }
    static void display(int arr[]){
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
        int[] arr = new int[20];
        arr[0] = 12;
        arr[1] = 16;
        arr[2] = 20;
        arr[3] = 40;
        arr[4] = 50;
        arr[5] = 70;
        int capacity = 20;
        int n = 6;
        System.out.println("Enter the element to insert : ");
        int key = sc.nextInt();

        System.out.print("Before Insertion: ");
		display(arr);

        // Inserting key
        n = insertSorted(arr, n, key, capacity);

        System.out.print("\nAfter Insertion: ");
        display(arr);
    }
}