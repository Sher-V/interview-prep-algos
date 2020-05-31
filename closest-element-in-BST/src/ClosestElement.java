public class ClosestElement {

    static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private int findClosestElement(Node current, int value) {
        if (current.value == value) return value;
        int closestElement = current.value;

        if (current.right != null && Math.abs(current.right.value - value) < Math.abs(closestElement - value))
            return findClosestElement(current.right, value);
        else if(current.left != null && Math.abs(current.left.value - value) < Math.abs(closestElement - value))
            return findClosestElement(current.left, value);
        return closestElement;
    }


    public static void main(String[] args) {
        Node root = new Node(9);
        root.left = new Node(4);
        root.right = new Node(17);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(7);
        root.right.right = new Node(22);
        root.right.right.left = new Node(20);

        ClosestElement closestElement = new ClosestElement();
        System.out.println(closestElement.findClosestElement(root, 18));
    }
}
