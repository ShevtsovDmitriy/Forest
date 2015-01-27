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
        Leaf<K, V> tmp = foundLeafByKey(key);
        if (tmp == null) return;
        size--;
        if (tmp.getRight() == null){
            if (tmp.getParent() == null) head = tmp.getLeft();
            else {
                if (tmp.getParent().getLeft().getKey() == tmp.getKey()){
                    tmp.getParent().setLeft(tmp.getLeft());
                }
                else tmp.getParent().setRight(tmp.getLeft());
            }
        }
        else {
            Leaf<K, V> left = tmp.getLeft();
            if (tmp.getParent() == null){
                head = tmp.getRight();
                tmp = tmp.getRight();
                while (tmp.getLeft() != null){
                    tmp = tmp.getLeft();
                }
                tmp.setLeft(left);
            }
            else {
                if (tmp.getParent().getLeft().getKey() == tmp.getKey()){
                    tmp.getParent().setLeft(tmp.getRight());
                    tmp = tmp.getRight();
                    while (tmp.getLeft() != null){
                        tmp = tmp.getLeft();
                    }
                    tmp.setLeft(left);
                }
                else {
                    tmp.getParent().setRight(tmp.getRight());
                    tmp = tmp.getRight();
                    while (tmp.getLeft() != null) {
                        tmp = tmp.getLeft();
                    }
                    tmp.setLeft(left);
                }
            }
        }
    }

    @Override
    public void removeByValue(V value) {

    }

    protected Leaf<K, V> foundLeafByKey(K key){
        Leaf<K, V> tmp = head;
        while (tmp != null) {
            int cmp = tmp.getKey().compareTo(key);
            if (cmp == 0) {
                return tmp;
            }
            if (cmp < 0) {
                tmp = tmp.getRight();
            } else tmp = tmp.getLeft();
        }
        return null;
    }

    @Override
    public V foundValue(K key) {
        Leaf<K, V> tmp = foundLeafByKey(key);
        if (tmp != null){
            return tmp.getValue();
        }
        System.out.print("\nKey not found");
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
        else System.out.print("\nElement with this key already exists");
        return false;
    }

}
