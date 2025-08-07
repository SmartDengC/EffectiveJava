package org.hahadeng.dp.mydecorate;

import java.util.*;

/**
 * @author 邓聪
 * @since 2025/6/3 17:41
 */
public class HistorySet<E> implements Set<E> {

    Queue<E> removeList = new PriorityQueue<>();

    // 放到类肚子里面
    // 当需要set有序？ 将Set的实现类用户传入
    // private Set<E> hashset = new HashSet<>();
    private final Set<E> delegate;

    public HistorySet(Set<E> delegate) {
        this.delegate = delegate;
    }

    @Override
    public String toString() {
        return "HistorySet{" +
                "removeList=" + removeList +
                ", hashset=" + delegate +
                '}';
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return delegate.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return delegate.add(e);
    }

    @Override
    public boolean remove(Object o) {
        boolean remove = delegate.remove(o);
        if (remove) {
            removeList.add((E) o);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
