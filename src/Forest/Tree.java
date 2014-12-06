package Forest;

public interface Tree<V> {
    public void add(V value);
    public void removeByKey(Integer key);
    public void removeByValue(V value);
    public V foundValue(Integer key);
    public Integer foundKey(V value);
    public V min();
    public V max();

}
