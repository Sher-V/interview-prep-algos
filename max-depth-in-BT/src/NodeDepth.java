import java.util.Stack;

public class NodeDepth {

    static class Node {
        Node left;
        Node right;
        int value;
        int depth;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

/*    public int findMaximumDepth(Node current) {

    }*/

    public int dfs(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        int res = 0;

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if(node.depth > res) res = node.depth;
            if (node.right != null) {
                stack.push(node.right);
                node.right.depth = node.depth + 1;
            }
            if (node.left != null) {
                stack.push(node.left);
                node.left.depth = node.depth + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.left.left.left = new Node(12);
        root.left.left.left.right = new Node(13);
        root.left.left.left.right.left = new Node(13);

        NodeDepth nodeDepth = new NodeDepth();
        System.out.println(nodeDepth.dfs(root));

    }
}
