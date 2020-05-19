import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node insert(Node current, int value) {
        if (current == null) return new Node(value);

        if (value < current.value) {
            current.left = insert(current.left, value);
        } else {
            current.right = insert(current.right, value);
        }

        return current;
    }

    private int countSum(Node root) {
        if (root == null) return 0;

        return root.value + countSum(root.left) + countSum(root.right);
    }

    public int countSum() {
        return countSum(root);
    }

    public void insert(int value) {
        root = insert(root, value);
    }
}
