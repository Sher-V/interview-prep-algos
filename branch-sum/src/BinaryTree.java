import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private Node root;
    private final List<Integer> sums = new ArrayList<>();

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int currentValue) {
            this.value = currentValue;
            this.left = null;
            this.right = null;
        }
    }


    private void countSum(Node currentNode, int currentValue) {

        // check whether it`s a leaf
        if (currentNode.left == null && currentNode.right == null)
            sums.add(currentNode.value + currentValue);

        if (currentNode.left != null)
            countSum(currentNode.left, currentNode.value + currentValue);

        if (currentNode.right != null)
            countSum(currentNode.right, currentNode.value + currentValue);

    }

    public void countSums() {
        countSum(root, 0);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);
        binaryTree.root.left.right.right = new Node(7);
        binaryTree.root.right.left = new Node(6);
        binaryTree.root.right.right = new Node(7);

        binaryTree.countSums();

        for (Integer currentValue : binaryTree.sums) {
            System.out.println(currentValue);
        }
    }
}
