import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // instantiate a new binary tree before going to the switch case using the
        // constructor

        BinarySearchTree binaryTree = new BinarySearchTree();
        boolean binaryTreeCreated = false;
        boolean continueRunning = true;

        do {
            // display a menue of options
            System.out.println("Please select an option below for the binary tree implementation:");
            System.out.println("1: Create a new binary tree");
            System.out.println("2: Add a new node to the binary tree");
            System.out.println("3: Delete a node from the binary tree");
            System.out.println("4: Search for a node in the binary tree");
            System.out.println("5: Print the binary tree in order");
            System.out.println("6: Print the binary tree pre-order");
            System.out.println("7: Print the binary tree post-order");
            System.out.println("8: Exit");
            Scanner scanner = new Scanner(System.in);
            

            try{
                int option = scanner.nextInt();
            if (option == 1) {
                int[] binaryTreeArray = { 1, 2, 3, 4, 5, 6, 7 };
                binaryTree.CreateBinarySearchTreeFromArray(binaryTreeArray);
                System.out.println("Binary tree created successfully");
                binaryTreeCreated = true;
            } else if (option == 2 && binaryTreeCreated) {
                System.out.println("Enter the value of the new node: ");
                int newNode = scanner.nextInt();
                binaryTree.insert(newNode);
            } else if (option == 3 && binaryTreeCreated) {
                System.out.println("Enter the value of the node to be deleted: ");
                int deleteNode = scanner.nextInt();
                binaryTree.deleteKey(deleteNode);
            } else if (option == 4 && binaryTreeCreated) {
                System.out.println("Enter the value of the node to be searched: ");
                int searchNode = scanner.nextInt();
                binaryTree.searchKey(searchNode);
            } else if (option == 5 && binaryTreeCreated) {
                binaryTree.printInorder();
            } else if (option == 6 && binaryTreeCreated) {
                binaryTree.printPreorder();
            } else if (option == 7 && binaryTreeCreated) {
                binaryTree.printPostorder();
            } else if (option == 8) {
                continueRunning = false;
                scanner.close();
            } else if (!binaryTreeCreated) {
                System.out.println("Please create a binary tree using option 1 first");

            } else {
                System.out.println("Invalid option exiting program");
                continueRunning = false;
                scanner.close();
            }
        } catch (Exception e) {
            System.out.println("Invalid option exiting program");
            continueRunning = false;
            scanner.close();
        }
        } while (continueRunning);
    }
}