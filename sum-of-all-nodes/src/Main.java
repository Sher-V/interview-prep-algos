public class Main {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(15);
        binarySearchTree.insert(10);
        binarySearchTree.insert(20);
        binarySearchTree.insert(8);
        binarySearchTree.insert(12);
        binarySearchTree.insert(16);
        binarySearchTree.insert(25);

        System.out.println(binarySearchTree.countSum());
    }
}
