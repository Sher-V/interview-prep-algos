import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Main {
    int res;
    Node root;

    public Main() {
        this.res = Integer.MIN_VALUE;
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private int findMaxPathSum(Node root) {
        if (root == null) return 0;

        int l = findMaxPathSum(root.left);
        int r = findMaxPathSum(root.right);

        int sum = root.value + Math.max(l, 0) + Math.max(r, 0);

        res = Math.max(sum, res);

        return sum;
    }

    public void findMaxPathSum() {
        findMaxPathSum(root);
    }



    public static void main(String[] args) {
        Main main = new Main();
        main.root = new Node(-10);
        main.root.left = new Node(9);
        main.root.right = new Node(20);
        main.root.right.left = new Node(15);
        main.root.right.right = new Node(7);

        main.findMaxPathSum();

        System.out.println(main.res);


    }
}
