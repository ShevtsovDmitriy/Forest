import Forest.BinaryTree;
import Forest.Tree;


public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.add(5);
        tree.add(6);
        tree.add(7, 1, false);
    }
}
