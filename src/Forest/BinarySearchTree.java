package Forest;

/**
 * Created by Дмитрий on 06.12.2014.
 */
public class BinarySearchTree<K extends Comparable<K>, V> implements Tree<K, V> {

    private Leaf<K, V> head;
    private int size = 0;

    @Override
    public void add(K key, V value) {
        if (head == null) {
            head = new Leaf<K, V>(key, value, null);
            size++;
        }
        else add(key, value, head);

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
        return null;
    }

    @Override
    public V max() {
        return null;
    }

    private void add(K key, V value, Leaf<K, V> place){
        if (place.getKey().compareTo(key) > 0){
            if(place.getLeft() == null){
                place.setLeft(new Leaf<K, V>(key, value, place));
                size++;
            }
            else add(key, value, place.getLeft());
        }
        else if (place.getKey().compareTo(key) < 0){
            if(place.getRight() == null){
                place.setRight(new Leaf<K, V>(key, value, place));
                size++;
            }
            else add(key, value, place.getRight());
        }
        else System.out.print("Element with this key already exists");
    }

}
