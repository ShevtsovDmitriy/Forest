package Forest;

/**
 * Created by Дмитрий on 06.12.2014.
 */
public class BinaryTree<K, V> implements Tree<K, V> {

    private Leaf<K, V> head;


    @Override
    public void add(K key, V value) {
        if (head == null){
            head = new Leaf<K, V>(key, value);
        }
        else add(K key, value, );
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

    public void add(K key, V value, K place, boolean isLeft){

    }


}
