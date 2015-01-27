import Forest.BinarySearchTree;
import Forest.BinaryTree;


public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer, Integer> tree = new BinaryTree<Integer, Integer>();
        tree.add(5, 4);
        tree.add(4, 5);
        tree.add(9, 53);
        tree.add(6, 0);
        tree.add(7, -1);
        tree.add(11, 1868);
        tree.add(3, 56);
        tree.add(10, 3);
        System.out.print(tree.max());
    }
}
