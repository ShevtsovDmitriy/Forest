package Forest;

/**
 * Created by Дмитрий on 06.12.2014.
 */
public class Leaf<K, V> {
    private K key;
    private V value;
    private Leaf<K, V> left;
    private Leaf<K, V> right;



    public Leaf(K key, V value) {
        this.key = key;
        this.value = value;
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
}
