package Forest;

public interface Tree<K, V> {
    public void add(K key, V value);
    public void removeByKey(K key);
    public void removeByValue(V value);
    public V foundValue(K key);
    public K foundKey(V value);
    public V min();
    public V max();

}
