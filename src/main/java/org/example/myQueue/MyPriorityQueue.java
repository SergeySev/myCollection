package org.example.myQueue;

import java.util.Comparator;
import java.util.Iterator;

public interface MyPriorityQueue {
    void add(Object element);
    void clear();
    Comparator<?> comparator();
    boolean contains(Object element);
    Iterator<Object> iterator();
    boolean offer(Object element);
    Object peek();
    Object poll();
    boolean remove(Object element);
    int size();
    Object[] toArray();

}
