package Forest;


import com.sun.org.apache.xpath.internal.operations.Equals;

public class BinaryTree<V extends Equals> implements Tree<V> {

    private Leaf<V> head;
    private int lastElement = -1;
    private int size = 0;

    public int getSize() {
        return size;
    }

    @Override
    public void add(V value) {
        if (head == null){
            head = new Leaf<V>(++lastElement, value);
            size++;
        }
        else add(value, lastElement, true);
    }

    @Override
    public void removeByKey(Integer key) {
        Leaf<V> remove = foundLeafByKey(key, head);

    }

    @Override
    public void removeByValue(V value) {

    }

    @Override
    public V foundValue(Integer key) {
        Leaf<V> found = foundLeafByKey(key, head);
        if (found != null) return found.getValue();
        return null;
    }

    @Override
    public Integer foundKey(V value) {
        Leaf<V> found = foundLeafByValue(value, head);
        if (found != null) return found.getKey();
        return null;
    }

    @Override
    public V min() {
        return null;
    }

    @Override
    public V max() {
        return null;
    }

    public void add(V value, Integer place, boolean isLeft){
        Leaf<V> parent = foundLeafByKey(place, head);
        if(parent == null) System.out.print("Key not found");
        else {
            if (isLeft) parent.setLeft(new Leaf<V>(++lastElement, value));
            else parent.setRight(new Leaf<V>(++lastElement, value));
            size++;
        }
    }

    private Leaf<V> foundLeafByKey(Integer key, Leaf<V> start){
        if (start.getKey().equals(key)) return start;
        Leaf<V> result = null;
        if (start.getLeft() != null) result = foundLeafByKey(key, start.getLeft());
        if (result == null){
            if (start.getRight() != null) return foundLeafByKey(key, start.getRight());
        }
        return result;
    }

    private Leaf<V> foundLeafByValue(V value, Leaf<V> start){
        if (start.getValue().equals(value)) return start;
        Leaf<V> result = null;
        if (start.getLeft() != null) result = foundLeafByValue(value, start.getLeft());
        if (result == null){
            if (start.getRight() != null) return foundLeafByValue(value, start.getRight());
        }
        return result;
    }


}
