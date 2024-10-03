import java.util.Scanner;

class BSTNode {
    int data;
    BSTNode left, right;

    // Constructor to create a new node
    public BSTNode(int value) {
        data = value;
        left = right = null;
    }
}

class BinarySearchTree {
    private BSTNode root;

    // Constructor to initialize the BST with an empty root
    public BinarySearchTree() {
        root = null;
    }

    // Method to insert a value into the BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive function to insert a value
    private BSTNode insertRec(BSTNode root, int value) {
        if (root == null) {
            root = new BSTNode(value);
            return root;
        }
        if (value < root.data) {
            root.left = insertRec(root.left, value);
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // Method to perform inorder traversal
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    // Recursive function for inorder traversal
    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Method to perform preorder traversal
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    // Recursive function for preorder traversal
    private void preorderRec(BSTNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Method to perform postorder traversal
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    // Recursive function for postorder traversal
    private void postorderRec(BSTNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }
}

class MenuDrivenBST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        int choice, value, n;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Create a BST with N integers");
            System.out.println("2. Traverse the BST in Inorder");
            System.out.println("3. Traverse the BST in Preorder");
            System.out.println("4. Traverse the BST in Postorder");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Create a BST by inserting N integers
                    System.out.print("Enter the number of integers to insert: ");
                    n = scanner.nextInt();
                    System.out.println("Enter the integers:");
                    for (int i = 0; i < n; i++) {
                        value = scanner.nextInt();
                        bst.insert(value);
                    }
                    break;
                case 2:
                    // Inorder traversal
                    System.out.println("Inorder Traversal:");
                    bst.inorder();
                    break;
                case 3:
                    // Preorder traversal
                    System.out.println("Preorder Traversal:");
                    bst.preorder();
                    break;
                case 4:
                    // Postorder traversal
                    System.out.println("Postorder Traversal:");
                    bst.postorder();
                    break;
                case 5:
                    // Exit
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

    }
}
