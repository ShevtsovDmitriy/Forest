package Forest;


public class Leaf<K, V> {
    private K key;
    private V value;
    private Leaf<K, V> left;
    private Leaf<K, V> right;
    private Leaf<K, V> parent;

    public Leaf(K key, V value, Leaf<K, V> parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
    }

    public void setLeft(Leaf<K, V> left) {
        this.left = left;
    }

    public void setRight(Leaf<K, V> right) {
        this.right = right;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Leaf<K, V> getLeft() {
        return left;
    }

    public Leaf<K, V> getRight() {
        return right;
    }

    public Leaf<K, V> getParent() {
        return parent;
    }
}
