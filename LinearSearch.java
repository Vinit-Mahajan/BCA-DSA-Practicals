import java.util.*;
class LinearSearch{

	static int search(int arr[], int ele){
		for(int i = 0 ; i < arr.length; i++){
			if(arr[i] == ele){
				return i;
			}
		}
		return 0;
	}
	public static void main(String[] args){
		int arr[] = new int[]{2,23,11,78,11,90,1};
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the elements to search : ");
		int ele = sc.nextInt();

		int res = search(arr, ele);
		if(res != 0) {
			System.out.println("Element found at " + res + " position");
		}
		else{
			System.out.println("Element not found.");
		}

	}
}