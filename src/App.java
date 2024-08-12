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
            System.out.println("\nPlease select an option below for the binary tree implementation:");
            System.out.println("1: Create a new binary tree");
            System.out.println("2: Add a new node to the binary tree");
            System.out.println("3: Delete a node from the binary tree");
            System.out.println("4: Print the binary tree in order");
            System.out.println("5: Print the binary tree pre-order");
            System.out.println("6: Print the binary tree post-order");
            System.out.println("7: exit");

            Scanner scanner = new Scanner(System.in);

            try {
                int option = scanner.nextInt();
                if (option == 1) {
                    System.out.println("Creating binary tree...");
                    // create a binary tree with the given array below as an example. The method
                    // will take any array of integers and convert it to a binary search tree
                    // the array below is just an example
                    int[] binaryTreeArray = { 1, 2, 3, 4, 5, 6, 7 };
                    binaryTree.CreateBinarySearchTreeFromArray(binaryTreeArray);
                    System.out.println("Binary tree created successfully");
                    // set the boolean to true to indicate that the binary tree has been created as
                    // we can now perform operations on it
                    binaryTreeCreated = true;
                } else if (option == 2 && binaryTreeCreated) {
                    System.out.println("Enter the value of the new node: ");
                    // add a new node to the binary search tree it should be an integer and the will
                    // add it in the correct order
                    int newNode = scanner.nextInt();
                    binaryTree.insert(newNode);
                } else if (option == 3 && binaryTreeCreated) {
                    // delete a node from the binary search tree if the node does not exist it will
                    // print that the node does not exist
                    System.out.println("Enter the value of the node to be deleted: ");
                    int deleteNode = scanner.nextInt();
                    binaryTree.deleteKey(deleteNode);
                } else if (option == 4 && binaryTreeCreated) {
                    // print the binary search tree in order
                    System.out.println("Printing binary tree in order...");
                    binaryTree.printInorder();
                } else if (option == 5 && binaryTreeCreated) {
                    // print the binary search tree in order
                    System.out.println("Printing binary tree in pre-order...");
                    binaryTree.printPreorder(); // print the binary tree in pre-order();
                } else if (option == 6 && binaryTreeCreated) {
                    // print the binary search tree in post-order
                    System.out.println("Printing bindary tree in post-order...");
                    binaryTree.printPostorder(); // print the binary search tree post-order();

                } else if (option == 7) {
                    // break the loop and exit the program
                    continueRunning = false;
                    scanner.close();
                } else if (!binaryTreeCreated) {
                    // if the binary tree has not been created yet prompt the user to create a
                    // binary tree using option 1
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