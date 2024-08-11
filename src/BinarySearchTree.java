// Reference: https://www.geeksforgeeks.org/java-program-to-construct-a-binary-search-tree/

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

    // The binary search tree will be created from the given array
    public void CreateBinarySearchTreeFromArray(int[] arr) {

        root = null;
        for (int num : arr) {
            insert(num);
        }
    }

    public void insert(int key) {
        root = recursiveNodeInsert(root, key);
    }

    private Node recursiveNodeInsert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = recursiveNodeInsert(root.left, key);
        else if (key > root.key)
            root.right = recursiveNodeInsert(root.right, key);

        return root;
    }

    public void printInorder() {
        printNodeInorderRecursive(root);
    }

    private void printNodeInorderRecursive(Node root) {
        if (root != null) {
            printNodeInorderRecursive(root.left);
            System.out.println(root.key);
            printNodeInorderRecursive(root.right);
        }
    }
}
