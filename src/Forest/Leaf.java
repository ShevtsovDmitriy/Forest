package Forest;


public class Leaf<V> {
    private Integer key;
    private V value;
    private Leaf<V> left;
    private Leaf<V> right;



    public Leaf(Integer key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setLeft(Leaf<V> left) {
        this.left = left;
    }

    public void setRight(Leaf<V> right) {
        this.right = right;
    }

    public Integer getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Leaf<V> getLeft() {
        return left;
    }

    public Leaf<V> getRight() {
        return right;
    }
}
