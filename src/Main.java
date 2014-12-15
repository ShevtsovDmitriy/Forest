import Forest.BinarySearchTree;
import Forest.BinaryTree;
import Forest.Tree;


public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
        tree.add(5, "fds");
        tree.add(4, "fesf");
        tree.add(9, "fds00");
        boolean res = tree.add(5, "fes");
        System.out.print(res);
    }
}
