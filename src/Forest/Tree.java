package Forest;

import java.io.Serializable;

public interface Tree<K extends Comparable<K>, V> extends Serializable, Iterable<K>{
    public boolean add(K key, V value);
    public void removeByKey(K key);
    public void removeByValue(V value);
    public V foundValue(K key);
    public K foundKey(V value);
    public V min();
    public V max();

}
