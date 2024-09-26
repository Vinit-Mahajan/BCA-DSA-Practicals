import java.util.Scanner;

public class MultiDimArray {

    public static int[][] addMatrices(int[][] m1, int[][] m2, int rows, int cols) {
        int result[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] m1, int m2[][], int rows, int cols) {
        int result[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = m1[i][j] - m2[i][j];
            }
        }
        return result;
    }

    public static void displayMatrix(int matrix[][], int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows of the matrices: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns of the matrices: ");
        int cols = scanner.nextInt();

        int m1[][] = new int[rows][cols];
        int m2[][] = new int[rows][cols];

        System.out.println("Enter the elements of the first matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the elements of the second matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m2[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Matrix M1:");
        displayMatrix(m1, rows, cols);

        System.out.println("Matrix M2:");
        displayMatrix(m2, rows, cols);

        int sumMatrix[][] = addMatrices(m1, m2, rows, cols);
        System.out.println("Addition of the matrices:");
        displayMatrix(sumMatrix, rows, cols);

        int differenceMatrix[][] = subtractMatrices(m1, m2, rows, cols);
        System.out.println("Subtraction of the matrices:");
        displayMatrix(differenceMatrix, rows, cols);

    }
}
