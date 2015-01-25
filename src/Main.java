import Forest.BinarySearchTree;



public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
        tree.add(5, "fds");
        tree.add(4, "fesf");
        tree.add(9, "fds00");
        tree.add(6, "fes");
        tree.add(7, "fds");
        tree.add(11, "fesf");
        tree.add(3, "fds00");
        tree.add(10, "fes");
        tree.removeByKey(5);
    }
}
