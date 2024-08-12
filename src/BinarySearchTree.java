/*refrences 
https://www.geeksforgeeks.org/java-program-to-construct-a-binary-search-tree/
https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
https://www.geeksforgeeks.org/preorder-traversal-of-binary-tree/
https://www.geeksforgeeks.org/postorder-traversal-of-binary-tree/
*/

import java.util.Arrays;

public class BinarySearchTree {

    // this class is used to create nodes in the binary search tree
    private class Node {
        int key;
        Node left, right;

        // constructor for the node class
        private Node(int item) {
            key = item;
            left = right = null; // set the left and right nodes to null as on creation it will not have any
                                 // addtional items
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // public method to create a binary search tree from an array
    // The binary search tree will be created from the given array
    public void CreateBinarySearchTreeFromArray(int[] arr) {
        // sort the array we could use a sorting algorithm for this, but we will just
        // use the bilt in option.
        Arrays.sort(arr);
        root = sortedArrayToTree(arr, 0, arr.length - 1);
    }

    private Node sortedArrayToTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        // find the middle of the array and set it as the root
        int mid = (start + end) / 2;

        // create a new node with the middle of the array is either or less than.
        Node root = new Node(arr[mid]);
        root.left = sortedArrayToTree(arr, start, mid - 1);
        root.right = sortedArrayToTree(arr, mid + 1, end);
        return root;
    }

    // public method to insert a node into the binary search tree
    public void insert(int key) {
        root = insertNodeTraversal(root, key);
    }

    // private method to insert a node into the binary search tree with the given
    // key encapsulated in the class. Insert Node relies on the insertNodeTraversal
    // method internally
    private Node insertNodeTraversal(Node root, int key) {
        // if there is not a root node, create one
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // if the key is less than the current node's key, go to the left from the
        // current node
        if (key < root.key)
            root.left = insertNodeTraversal(root.left, key);
        // if the key is greater than the current node's key, go to the right from the
        // current node
        else if (key > root.key)
            root.right = insertNodeTraversal(root.right, key);

        return root;
    }

    // public method to print the root node it is not needed for this example. But
    // can be utilized if using the class later for addtional functionality
    public void rootNode() {
        System.out.println("\n" + root.key);
    }

    public void printInorder() {
        printNodeInorderTraversal(root);
    }

    // private method to print the binary search tree in order traversal with the
    // root node encapsulated in the class. Print Inorder relies on the
    // printNodeInorderTraversal method internally
    private void printNodeInorderTraversal(Node root) {
        if (root != null) {
            // move as far left as possible until the next node is null and then start
            // printing and moving right
            printNodeInorderTraversal(root.left);
            System.out.println("\n" + root.key);
            printNodeInorderTraversal(root.right);
        }
    }

    public void printPreorder() {
        printNodePreorderTraversal(root);
    }

    private void printNodePreorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.println("\n" + root.key);
        printNodePreorderTraversal(root.left);
        printNodePreorderTraversal(root.right);
    }

    public void printPostorder() {
        printNodePostorderTraversal(root);
    }

    private void printNodePostorderTraversal(Node root) {
        if (root != null) {
            printNodePostorderTraversal(root.left);
            printNodePostorderTraversal(root.right);
            System.out.println("\n" + root.key);
        }
    }

    // public method to search for a key in the binary search tree and print out the
    // result.
    // This is not used for this example assignment however, it can be utilized if
    // needed in the future.
    public void searchKey(int key) {
        boolean found = searchKeyNodeTraversal(root, key);
        if (found) {
            System.out.println("\nKey found in the tree!");
        } else {
            System.out.println("\nKey not found in the tree!");
        }
    }

    // private method to search for a key in the binary search tree with the given
    // key.
    // searching is not utilized for this example assignment however, this method is
    // used in the deleteKey method to make sure the key is present.
    // We do not need it for the delete option to be effective but it does allow us
    // to catch if the key is not present.
    // do note however that this makes the node delete slighlyly less efficent as it
    // does run through the entire tree first to see if the key is present prior to
    // running the delete.
    private boolean searchKeyNodeTraversal(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.key == key)
            return true;

        // Key is greater than root's key
        if (root.key > key)
            return searchKeyNodeTraversal(root.left, key);

        // Key is less than root's key
        return searchKeyNodeTraversal(root.right, key);

    }

    public void deleteKey(int key) {

        root = deleteKeyNodeTraversal(root, key);
    }

    // private method to delete a node from the binary search tree with the given
    // key encapsulated in the class. Delete Key relies on the
    // deleteKeyNodeTraversal method internally
    private Node deleteKeyNodeTraversal(Node root, int key) {

        // if the tree is empty or the key is not found in the tree return the root node
        // and print that the key was not found
        boolean found = searchKeyNodeTraversal(root, key);
        if (!found) {
            System.out.println("\nKey not found");
            return root;
        }

        // if (root == null) return root;

        if (key < root.key)
            root.left = deleteKeyNodeTraversal(root.left, key);
        else if (key > root.key)
            root.right = deleteKeyNodeTraversal(root.right, key);
        else {
            if (root.left == null) {
                System.out.println("\nKey " + root.key + " was deleted from the BST.");
                return root.right;
            } else if (root.right == null) {
                System.out.println("\nKey " + root.key + " was deleted from the BST.");
                return root.left;
            }

            root.key = minValue(root.right);

            System.out.println("\nKey " + root.key + " was deleted from the BST.");
            root.right = deleteKeyNodeTraversal(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        // move as far left as possible until the next node is null that should be the
        // minimum value.
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
}
