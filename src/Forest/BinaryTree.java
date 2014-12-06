package Forest;


public class BinaryTree<K, V> implements Tree<K, V> {

    private Leaf<K, V> head;
    private int size = 0;

    public int getSize() {
        return size;
    }

    @Override
    public void add(K key, V value) {
        if (head == null){
            head = new Leaf<K, V>(key, value, null);
            size++;
        }
        else {
            Leaf<K, V> currentElement = head;
            Leaf<K, V> parentElement = head;
            while (currentElement.getLeft() != null) {
                parentElement = currentElement;
                currentElement = currentElement.getLeft();
            }
            currentElement.setLeft(new Leaf<K, V>(key, value, parentElement));
        }
    }

    @Override
    public void removeByKey(K key) {
        //Leaf<K, V> remove = foundLeafByKey(key, head);

    }

    @Override
    public void removeByValue(V value) {

    }

    @Override
    public V foundValue(K key) {
        Leaf<K, V> found = foundLeafByKey(key, head);
        if (found != null) return found.getValue();
        return null;
    }

    @Override
    public K foundKey(V value) {
        Leaf<K, V> found = foundLeafByValue(value, head);
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

    public void add(K key, V value, K place, boolean isLeft){
        Leaf<K, V> parent = foundLeafByKey(place, head);
        if(parent == null) System.out.print("Key not found");
        else {
            if (isLeft) parent.setLeft(new Leaf<K, V>(key, value, parent));
            else parent.setRight(new Leaf<K, V>(key, value, parent));
            size++;
        }
    }

    private Leaf<K, V> foundLeafByKey(K key, Leaf<K, V> start){
        if (start.getKey().equals(key)) return start;
        Leaf<K, V> result = null;
        if (start.getLeft() != null) result = foundLeafByKey(key, start.getLeft());
        if (result == null){
            if (start.getRight() != null) return foundLeafByKey(key, start.getRight());
        }
        return result;
    }

    private Leaf<K, V> foundLeafByValue(V value, Leaf<K, V> start){
        if (start.getValue().equals(value)) return start;
        Leaf<K, V> result = null;
        if (start.getLeft() != null) result = foundLeafByValue(value, start.getLeft());
        if (result == null){
            if (start.getRight() != null) return foundLeafByValue(value, start.getRight());
        }
        return result;
    }


}
