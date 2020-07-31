/*
Implement an algorithm to find the kth to last element of a singly linked list.
*/

public class Node {
    Node next = null;
    int data;

    public Node(int data) {
        this.data = data;
    }

    private void appendToTail(int d) {
        Node node = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
    }

    private Node findKthToLastNode(int k) {
        Node n = this;
        int count = 1;
        while (n.next != null) {
            n = n.next;
            count++;
        }
        n = this;
        while (count != k) {
            assert n != null;
            n = n.next;
            count--;
        }

        return n;
    }

    public static void main(String[] args) {
        Node node = new Node(6);
        node.appendToTail(5);
        node.appendToTail(5);
        node.appendToTail(1);
        node.appendToTail(25);
        node.appendToTail(3);
        node.appendToTail(4);
        node.appendToTail(5);
        node.appendToTail(8);
        System.out.println(node.findKthToLastNode(9).data);

    }
}
