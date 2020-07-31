/*
    Remove Dups: Write code to remove duplicates from an unsorted linked list.
    FOLLOW UP

    How would you solve this problem if a temporary buffer is not allowed?
*/

import java.util.HashSet;

public class Node {
    Node next = null;
    int data;

    public Node(int data) {
        this.data = data;
    }

    private void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;

        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    // with a temporary buffer
    private void removeDuplicates1() {
        HashSet<Integer> hashSet = new HashSet<>();

        Node n = this;
        hashSet.add(n.data);
        while (n.next != null) {
            if (hashSet.contains(n.next.data)) n.next = n.next.next;
            else {
                hashSet.add(n.next.data);
                n = n.next;
            }
        }
    }

    private void removeDuplicates2() {
        Node n1 = this;
        Node n2 = this;

        while (n1.next != null) {
            while (n2.next != null) {
                if (n1.data == n2.next.data) n2.next = n2.next.next;
                else n2 = n2.next;
            }
            if (n1.next == null) break;
            n2 = n1 = n1.next;
        }
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.appendToTail(5);
        node.appendToTail(1);
        node.appendToTail(2);
        node.appendToTail(2);
        node.appendToTail(4);
        node.appendToTail(12);
        node.appendToTail(32);
        node.appendToTail(32);

        node.removeDuplicates2();
    }
}
