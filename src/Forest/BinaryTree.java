package Forest;


import java.io.Serializable;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class BinaryTree<K extends Comparable<K>, V extends Comparable<V>> implements Tree<K, V>, Serializable, Iterable<K>{

    private Leaf<K, V> head;
    private int size = 0;
    private V min;
    private V max;

    public int getSize() {
        return size;
    }

    @Override
    public boolean add(K key, V value) {
        if (head == null){
            head = new Leaf<K, V>(key, value, null);
            size++;
            return true;
        }
        else {
            if (foundLeafByKey(key, head) != null) {
                System.out.print("Element with this key already exists");
                return false;
            }
            else {
                Leaf<K, V> currentElement = head;
                Leaf<K, V> parentElement = head;
                while (currentElement.getLeft() != null) {
                    parentElement = currentElement;
                    currentElement = currentElement.getLeft();
                }
                currentElement.setLeft(new Leaf<K, V>(key, value, parentElement));
                return true;
            }
        }
    }

    @Override
    public void removeByKey(K key) {
        Leaf<K, V> tmp = foundLeafByKey(key, head);
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

    private void foundMin(Leaf<K, V> currentLeaf){
        if (currentLeaf.getValue().compareTo(min) < 0){
            min = currentLeaf.getValue();
        }
        if (currentLeaf.getLeft() != null) {
            foundMin(currentLeaf.getLeft());
        }
        if (currentLeaf.getRight() != null){
            foundMin(currentLeaf.getRight());
        }
    }

    private void foundMax(Leaf<K, V> currentLeaf){
        if (currentLeaf.getValue().compareTo(max) > 0){
            max = currentLeaf.getValue();
        }
        if (currentLeaf.getLeft() != null) {
            foundMax(currentLeaf.getLeft());
        }
        if (currentLeaf.getRight() != null){
            foundMax(currentLeaf.getRight());
        }
    }

    @Override
    public V min() {
        if (head != null) {
            min = head.getValue();
            foundMin(head);
            return min;
        }
        return null;
    }
    @Override
    public V max() {
        if (head != null) {
            max = head.getValue();
            foundMax(head);
            return max;
        }
        return null;
    }

    public boolean add(K key, V value, K place, boolean isLeft){
        Leaf<K, V> parent = foundLeafByKey(place, head);
        if (foundLeafByKey(key, head) != null) {
            System.out.print("\nElement with this key already exists");
            return false;
        }
        if(parent == null){
            System.out.print("\nParent not found");
            return false;
        }
        else {
            if (isLeft){
                parent.setLeft(new Leaf<K, V>(key, value, parent));
                return true;
            }
            else parent.setRight(new Leaf<K, V>(key, value, parent));
            size++;
            return true;
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


    @Override
    public Iterator<K> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super K> action) {

    }

    @Override
    public Spliterator<K> spliterator() {
        return null;
    }
}
