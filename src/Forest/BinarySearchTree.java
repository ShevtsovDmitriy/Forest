package Forest;

public class BinarySearchTree<K extends Comparable<K>, V> implements Tree<K, V> {

    private Leaf<K, V> head;
    private int size = 0;

    @Override
    public boolean add(K key, V value) {
        if (head == null) {
            head = new Leaf<K, V>(key, value, null);
            size++;
            return true;
        }
        else return add(key, value, head);
    }

    @Override
    public void removeByKey(K key) {

    }

    @Override
    public void removeByValue(V value) {

    }

    @Override
    public V foundValue(K key) {
        return null;
    }

    @Override
    public K foundKey(V value) {
        return null;
    }

    @Override
    public V min() {
        if (head == null) return null;
        Leaf<K, V> currentElement = head;
        while (currentElement.getLeft() != null) currentElement = currentElement.getLeft();
        return currentElement.getValue();
    }

    @Override
    public V max() {
        if (head == null) return null;
        Leaf<K, V> currentElement = head;
        while (currentElement.getRight() != null) currentElement = currentElement.getRight();
        return currentElement.getValue();
    }

    private boolean add(K key, V value, Leaf<K, V> place){
        if (place.getKey().compareTo(key) > 0){
            if(place.getLeft() == null){
                place.setLeft(new Leaf<K, V>(key, value, place));
                size++;
                return true;
            }
            else return add(key, value, place.getLeft());
        }
        else if (place.getKey().compareTo(key) < 0){
            if(place.getRight() == null){
                place.setRight(new Leaf<K, V>(key, value, place));
                size++;
                return true;
            }
            else return add(key, value, place.getRight());
        }
        else System.out.print("Element with this key already exists");
        return false;
    }

}
